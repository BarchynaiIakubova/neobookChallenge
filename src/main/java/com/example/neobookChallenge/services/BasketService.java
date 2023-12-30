package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.NotFoundException;
import com.example.neobookChallenge.models.OrderProduct;
import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.models.User;
import com.example.neobookChallenge.repositories.BasketRepository;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.repositories.UserRepository;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
public class BasketService {


    private final BasketRepository basketRepository;

    private final ProductRepository productRepository;

    private final UserService userService;

    private final UserRepository userRepository;

    public Response addProductToBasket(Long userId, Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product is not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        user.addProductToBasket(product);

        Product product1 = user.getBasket().stream().filter(p -> p.getId().equals(productId)).findFirst().get();

//        OrderProduct basket = OrderProduct.builder()
//                .productName(product.getTitle())
//                .productPrice(product.getPrice())
//                .productImage(product.getImage())
//                .quantity(1)
//                .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(1)))
//                .build()

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
