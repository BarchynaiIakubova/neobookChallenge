package com.example.neobookChallenge.requests;

public record OrderRequest(
        String phoneNumber,
        String address,
        String landmark,
        String comments
) {
}
