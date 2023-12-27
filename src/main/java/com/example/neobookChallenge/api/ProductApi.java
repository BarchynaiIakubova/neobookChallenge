package com.example.neobookChallenge.api;

import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.requests.ProductRequest;
import com.example.neobookChallenge.responses.ProductGetAllResponse;
import com.example.neobookChallenge.responses.Response;
import com.example.neobookChallenge.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "Product Api", description = "Product endpoints")
public class ProductApi {

    private final ProductService productService;

    @PostMapping("/{categoryId}")
    @Operation(summary = "Save Product", description = "This method saves product")
    Response save(@PathVariable Long categoryId, @RequestBody ProductRequest productRequest) {

        return productService.save(categoryId, productRequest);
    }

    @GetMapping
    @Operation(summary = "Find All Products", description = "This method finds all products")
    List<ProductGetAllResponse> findAll() {

        return productService.findAll();
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Get by Id", description = "This method gets product by Id")
    ProductGetAllResponse findById(@PathVariable Long productId) {

        return productService.findByIdProduct(productId);
    }

    @PutMapping("/{productId}")
    @Operation(summary = "Update Product", description = "This method updates product by Id")
    Response update(@PathVariable Long productId, @RequestBody ProductRequest productRequest) {

        return productService.update(productId, productRequest);

    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Delete Product", description = "This method deletes product by Id")
    Response delete(@PathVariable Long productId) {

        return productService.deleteByProductId(productId);
    }


    @GetMapping("/pagination")
    @Operation(summary = "Search product", description = "This method searches products")
    List<ProductGetAllResponse> findAllProducts(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        return productService.findAllProducts(search, page, size);

    }

}
