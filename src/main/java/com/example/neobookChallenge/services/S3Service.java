package com.example.neobookChallenge.services;

import com.example.neobookChallenge.responses.ImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class S3Service {

    public ImageResponse upload(MultipartFile file) {
        return null;
    }
}
