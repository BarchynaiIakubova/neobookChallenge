package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.NotFoundException;
import com.example.neobookChallenge.models.Basket;
import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.repositories.BasketRepository;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BasketService {


    private final BasketRepository basketRepository;

    private final ProductRepository productRepository;

    private final UserService userService;

    public Response addProductToBasket(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product is not found"));

        Basket basket = Basket.builder()
                .productName(product.getTitle())
                .productPrice(product.getPrice())
                .productImage(product.getImage())
                .quantity(1)
                .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(1)))
                .build();

        basketRepository.save(basket);

        return new Response("The product added to the basket");
    }


//    @Transactional
//    public Response addQuantityOfProductInBasket(Long basketId) {
//
//        Basket basket = basketRepository.findById(basketId)
//                .orElseThrow(() -> new NotFoundException("Product is not found"));
//
//
//
//        Integer newQuantity = basket.getQuantity();
//
//        basket.setQuantity(newQuantity + 1);
//
//        basket.setTotalPrice(basket.getQuantity());
//
//        return new Response("The quantity of the product changed");
//    }
}
