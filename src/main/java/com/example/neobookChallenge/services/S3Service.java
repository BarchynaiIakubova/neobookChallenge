package com.example.neobookChallenge.services;

import com.example.neobookChallenge.responses.ImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${cloud.aws.bucket.name}")
    private String bucketName;

    private final S3Client s3Client;

    public ImageResponse upload(MultipartFile file) {

        String key = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try {

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

            return imageService
        }
        return null;
    }
}
