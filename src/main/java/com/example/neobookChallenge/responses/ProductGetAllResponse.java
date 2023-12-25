package com.example.neobookChallenge.responses;

import java.math.BigDecimal;

public record ProductGetAllResponse(

        Long id,
        String title,
        BigDecimal price,
        String image
) {
}
