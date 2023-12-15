package com.example.neobookChallenge.api;

import com.example.neobookChallenge.requests.ProductRequest;
import com.example.neobookChallenge.responses.Response;
import com.example.neobookChallenge.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "Product Api", description = "Product endpoints")
public class ProductApi {

    private final ProductService productService;

    @PostMapping
    Response save(@RequestBody ProductRequest productRequest) {

        return productService.save(productRequest);
    }
}
