package com.example.neobookChallenge.responses;

import com.example.neobookChallenge.models.Product;

import java.math.BigDecimal;
import java.util.List;

public record BasketResponse(
        List<BasketProductResponse> product
) {
}
