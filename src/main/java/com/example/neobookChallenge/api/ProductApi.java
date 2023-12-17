package com.example.neobookChallenge.api;

import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.requests.ProductRequest;
import com.example.neobookChallenge.responses.ProductGetAllResponse;
import com.example.neobookChallenge.responses.Response;
import com.example.neobookChallenge.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    List<ProductGetAllResponse> findAll() {

        return productService.findAll();
    }

    @GetMapping("/{productId}")
    Optional<Product> findById(@PathVariable Long productId) {

        return productService.findById(productId);

    }

    @PutMapping("/{productId}")
    Response update(@PathVariable Long productId, @RequestBody ProductRequest productRequest) {


    }
}
