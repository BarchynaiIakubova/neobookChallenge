package com.example.neobookChallenge.responses;

public record ProductGetAllResponse(

        Long id,
        String title,
        Integer price,
        String currencyAndInfo,
        String image
) {
}
