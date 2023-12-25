package com.example.neobookChallenge.requests;

import com.example.neobookChallenge.models.Category;

import java.math.BigDecimal;

public record ProductRequest(
        String title,
        BigDecimal price,
        String description,
        String image

){
}
