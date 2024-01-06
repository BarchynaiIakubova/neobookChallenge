package com.example.neobookChallenge.responses;

import java.math.BigDecimal;
import java.util.List;

public record BasketProductResponse(
        Long productId,
        String name,
        String image,
        BigDecimal price,
        Integer quantity,
        BigDecimal totalPrice
) {
}
