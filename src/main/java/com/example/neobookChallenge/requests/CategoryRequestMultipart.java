package com.example.neobookChallenge.requests;

import org.springframework.web.multipart.MultipartFile;

public record CategoryRequestMultipart(
        String title,
        MultipartFile image
) {
}
