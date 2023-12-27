package com.example.neobookChallenge.api;

import com.example.neobookChallenge.responses.Response;
import com.example.neobookChallenge.services.BasketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/baskets")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "Basket Api", description = "Basket Endpoints")
public class BasketApi {

    private final BasketService basketService;

    @PostMapping("/{productId}")
    Response addProductToBasket(@PathVariable Long productId) {

        return basketService.addProductToBasket(productId);
    }

//    @PutMapping("/{productId}")
//    Response changeProductInBasket(@PathVariable Long basketId) {
//
//        return basketService.addQuantityOfProductInBasket(basketId);
//
//    }


}
