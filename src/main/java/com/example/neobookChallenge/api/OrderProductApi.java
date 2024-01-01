package com.example.neobookChallenge.api;

import com.example.neobookChallenge.models.Order;
import com.example.neobookChallenge.models.OrderProduct;
import com.example.neobookChallenge.responses.OrderResponse;
import com.example.neobookChallenge.services.OrderProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/histories")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "Order Product Api", description = "History endpoints")
public class OrderProductApi {

    private final OrderProductService orderProductService;

    @GetMapping
    List<OrderResponse> findAllOrders() {

        return orderProductService.findAllOrders();
    }
}
