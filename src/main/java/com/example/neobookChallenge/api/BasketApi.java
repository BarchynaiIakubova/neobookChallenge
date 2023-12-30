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

    @PostMapping("/{userId}/{productId}")
    Response addProductToBasket(@PathVariable Long userId,
                                @PathVariable Long productId) {

        return basketService.addProductToBasket(userId, productId);
    }

    @PutMapping("/{userId}/{productId}")
    Response deleteProductByOneInBasket(@PathVariable Long userId,
                                   @PathVariable Long productId) {

        return basketService.deleteProductByOneInBasket(userId, productId);

    }

    @DeleteMapping("/{userId}/{productId}")
    Response deleteProductInBasket(@PathVariable Long userId,
                                   @PathVariable Long productId) {

        return basketService.deleteProductInBasket(userId, productId);
    }


}
