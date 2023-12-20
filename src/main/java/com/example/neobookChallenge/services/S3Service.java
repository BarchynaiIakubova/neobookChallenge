package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.BadRequestException;
import com.example.neobookChallenge.responses.ImageResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${cloud.aws.bucket.name}")
    private String bucketName;

    @Value("${cloud.aws.bucket.path}")
    private String path;

    @Value("${cloud.aws.bucket.region}")
    private String region;

    private final S3Client s3Client;

    public ImageResponse upload(MultipartFile file) {

        String key = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try {

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

            return new ImageResponse(path + key);
        } catch (IOException | S3Exception e) {

            e.printStackTrace();
            throw new BadRequestException("Failed to load the image. Please try again later");
        }
    }


    public void deletePath(String fileLink) {

        try{

            String key = fileLink.substring(path.length());

            System.out.println("Deleting object with key: " + key + " from bucket: " + bucketName);


            s3Client.deleteObject(file ->file
                .bucket(bucketName)
                .key(key)
                .build());

            System.out.println("Object deleted successfully.");
    } catch (S3Exception e) {

        throw new IllegalStateException(e.awsErrorDetails().errorMessage());
    } catch (Exception e) {

        throw new IllegalStateException(e.getMessage());
    }

    }


}
