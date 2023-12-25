package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.NotFoundException;
import com.example.neobookChallenge.models.Basket;
import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.repositories.BasketRepository;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {


    private final BasketRepository basketRepository;

    private final ProductRepository productRepository;

    public Response addProductToBasket(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product is not found"));

        Basket basket = Basket.builder()
                .productName(product.getTitle())
                .productPrice(product.getPrice())
                .productImage(product.getImage())
                .quantity(1)
                .build();

        basketRepository.save(basket);

        return new Response("The product added to the basket");
    }


}
