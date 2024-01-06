package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.NotFoundException;
import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.models.User;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.repositories.UserRepository;
import com.example.neobookChallenge.responses.BasketProductResponse;
import com.example.neobookChallenge.responses.BasketResponse;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class BasketService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    @Transactional
    public Response addProductToBasket(Long userId, Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product is not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        user.addProductToBasket(product);

        return new Response("The product added to the basket");
    }


    @Transactional
    public Response deleteProductByOneInBasket(Long userId, Long productId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        user.getBasket().stream().filter(p -> p.getId().equals(productId)).findFirst()
                .ifPresent(user.getBasket()::remove);

        return new Response("The product removed from the basket");
    }


    @Transactional
    public Response deleteProductInBasket(Long userId, Long productId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        user.getBasket().removeIf(p -> p.getId().equals(productId));

        return new Response("The product is removed");
    }



    public BasketResponse findAllProductsInBasket(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User is not found"));

        List<Product> basket = user.getBasket();

        List<Product> products = new ArrayList<>();

        for (Product product : basket) {
            if (!products.contains(product)) {
                products.add(product);
            }
        }

        List<BasketProductResponse> basketProduct = new ArrayList<>();

        for (Product product : products) {

            Integer quantity1 = quantity(user.getBasket(), product.getId());

            basketProduct.add(
                    new BasketProductResponse(
                     product.getId(),
                     product.getTitle(),
                     product.getImage(),
                     product.getPrice(),
                            quantity1,
                            product.getPrice().multiply(BigDecimal.valueOf(quantity1))
                    )
            );
        }

        return new BasketResponse(basketProduct);
    }

    private Integer quantity(List<Product> products, Long productId) {

        int quantity = 0;

        for (Product product : products) {

            if (product.getId().equals(productId))

                quantity++;
        }
        return quantity;
    }


//    public Product getProduct() {
//
//        return new Product();
//    }
}
