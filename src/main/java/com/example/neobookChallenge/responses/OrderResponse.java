package com.example.neobookChallenge.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        String orderNumber,
        LocalDateTime localDateTime,
        BigDecimal totalPrice
) {
}
