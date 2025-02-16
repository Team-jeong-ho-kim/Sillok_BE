package com.example.sillok_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SillokServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SillokServerApplication.class, args);
    }

}