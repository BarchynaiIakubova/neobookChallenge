package com.example.neobookChallenge.requests;

import com.example.neobookChallenge.models.Category;

public record ProductRequest(
        Long id,
        String title,
        Integer price,
        String description,
        String image,
        Category categoryId
){
}
