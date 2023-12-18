package com.example.neobookChallenge.responses;

public record ExceptionResponse(
        String exceptionClassName,
        String message
) {
}
