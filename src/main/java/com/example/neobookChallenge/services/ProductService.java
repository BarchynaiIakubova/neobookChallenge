package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.requests.ProductRequest;
import com.example.neobookChallenge.responses.ProductGetAllResponse;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Value("${cloud.aws.bucket.path}")
    private String path;

    public Response save(ProductRequest productRequest) {

        Product product = Product.builder()
                .id(productRequest.id())
                .title(productRequest.title())
                .price(productRequest.price())
                .description(productRequest.description())
                .image(productRequest.image().substring(path.length()))
                .category(productRequest.categoryId())
                .build();

        productRepository.save(product);

        return new Response("Product successfully was saved");
    }


    public List<ProductGetAllResponse> findAll() {

        return productRepository.findAllProducts(path);
    }

    public Optional<Product> findById(Long productId) {

       return productRepository.findById(productId);
    }
}
