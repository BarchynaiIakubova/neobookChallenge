package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.requests.ProductRequest;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Response save(ProductRequest productRequest) {

        Product product = Product.builder()
                .id(productRequest.id())
                .title(productRequest.title())
                .price(productRequest.price())
                .description(productRequest.description())
                .image(productRequest.image())
                .category(productRequest.categoryId())
                .build();

        productRepository.save(product);

        return new Response("Product successfully was saved");
    }
}
