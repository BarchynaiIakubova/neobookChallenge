package com.example.neobookChallenge.requests;

import org.springframework.web.multipart.MultipartFile;

public record CategoryRequest(
        String title,
        String image
) {
}
