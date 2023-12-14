package com.example.neobookChallenge.api;


import com.example.neobookChallenge.responses.ImageResponse;
import com.example.neobookChallenge.services.S3Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/s3")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "File API", description = "S3 endpoints")
public class S3Api {

    private final S3Service service;

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ImageResponse upload(@RequestParam(name = "file", required = false)MultipartFile file) {

        return service.upload(file);
    }

}
