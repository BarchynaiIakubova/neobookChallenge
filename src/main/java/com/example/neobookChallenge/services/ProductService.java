package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.NotFoundException;
import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.requests.ProductRequest;
import com.example.neobookChallenge.responses.ProductGetAllResponse;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Product findById(Long productId) {

       return productRepository.findById(productId)
               .orElseThrow(() -> new NotFoundException("The product is not found"));
    }


    @Transactional
    public Response update(Long productId, ProductRequest productRequest) {

        Product product = findById(productId);

        product.setTitle(productRequest.title());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setImage(productRequest.image());
        product.setCategory(productRequest.categoryId());

        return new Response("updated");
    }

    public Response deleteByProductId(Long productId) {

        productRepository.deleteById(productId);

        return new Response("Product Successfully removed");
    }
}
