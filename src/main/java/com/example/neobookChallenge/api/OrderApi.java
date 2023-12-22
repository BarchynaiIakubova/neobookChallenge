package com.example.neobookChallenge.api;

import com.example.neobookChallenge.requests.OrderRequest;
import com.example.neobookChallenge.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oder")
@CrossOrigin("origins = \"*\", originPatterns = \"*\", maxAge = 5000, exposedHeaders = \"Access-Control-Allow-Origin\", allowedHeaders = \"*\"")
@Tag(name = "Oder Api", description = "Order endpoints")
public class OrderApi {

    private final OrderService orderService;

    @PostMapping
    String save(@RequestBody OrderRequest orderRequest) {

        return orderService.save(orderRequest);
    }
}
