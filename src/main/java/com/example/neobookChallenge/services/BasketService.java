package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.NotFoundException;
import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.models.User;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.repositories.UserRepository;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BasketService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    public Response addProductToBasket(Long userId, Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product is not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        user.addProductToBasket(product);

//        product.getPrice() * ;
        return new Response("The product added to the basket");
    }


    public Response deleteProductByOneInBasket(Long userId, Long productId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        user.getBasket().stream().filter(p -> p.getId().equals(productId)).findFirst()
                .ifPresent(user.getBasket()::remove);

        return new Response("The product removed from the basket");
    }


    public Response deleteProductInBasket(Long userId, Long productId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        user.getBasket().removeIf(p -> p.getId().equals(productId));

        return new Response("The product is removed");
    }
}
