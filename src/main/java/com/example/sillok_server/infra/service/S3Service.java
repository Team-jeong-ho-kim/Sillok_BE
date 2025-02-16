package com.example.sillok_server.infra.service;

import com.example.sillok_server.infra.exception.DeleteImageFailedException;
import com.example.sillok_server.infra.exception.ImageNotFoundException;
import com.example.sillok_server.infra.exception.InvalidImageException;
import com.example.sillok_server.infra.s3.S3Properties;
import com.example.sillok_server.infra.type.FolderType;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final Set<String> IMAGE_EXTENSIONS = Set.of(".jpg", ".jpeg", ".png", ".gif");

    private final S3Properties s3Properties;
    private final S3Operations s3Operations;

    public String uploadImage(MultipartFile file, FolderType folderType) throws IOException {
        String fileName = file.getOriginalFilename();
        validate(fileName);

        String key = generateKey(fileName, folderType);

        s3Operations.upload(
                s3Properties.bucket(),
                key,
                file.getInputStream(),
                ObjectMetadata.builder()
                        .contentType(file.getContentType())
                        .build());

        return key;
    }

    public void deleteImage(String imageUrl) {
        String key = getKey(imageUrl);
        s3Operations.deleteObject(s3Properties.bucket(), key);
    }

    private void validate(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw ImageNotFoundException.EXCEPTION;
        }

        String extension = getExtension(fileName);
        if (!IMAGE_EXTENSIONS.contains(extension)) {
            throw InvalidImageException.EXCEPTION;
        }
    }

    private String generateKey(String originalFilename, FolderType folderType) {
        String path;
        switch (folderType) {
            case PROFILE_IMAGES -> path = s3Properties.profileImages();
            case PREVIEW_IMAGES -> path = s3Properties.previewImages();
            case POST_IMAGES -> path = s3Properties.postImages();
            default -> throw InvalidImageException.EXCEPTION;
        }

        String extension = getExtension(originalFilename);
        return path + "/" + UUID.randomUUID() + extension;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
    }

    private String getKey(String imageUrl) {
        try {
            URL url = new URI(imageUrl).toURL();
            String decodedKey = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8);

            if (decodedKey.startsWith("/")) {
                return decodedKey.substring(1);
            }
            return decodedKey;
        } catch (Exception e) {
            throw DeleteImageFailedException.EXCEPTION;
        }
    }

}