package com.example.sillok_server.infra.s3;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cloud.aws.s3")
public record S3Properties(
        String bucket,
        String accessKey,
        String secretKey,
        String postImages,
        String previewImages,
        String profileImages,
        String url
) {
}