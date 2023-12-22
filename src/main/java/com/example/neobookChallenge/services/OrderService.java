package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.Order;
import com.example.neobookChallenge.repositories.OrderRepository;
import com.example.neobookChallenge.requests.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

//    public List<Order> findAll() {
//
//        return orderRepository.findAll();
//    }

    public String save(OrderRequest orderRequest) {

        Random random = new Random();

        Long orderNumber = random.nextLong(100000000, 999999999);

        List<Order> orders = new ArrayList<>();


        for(Order order : orders) {

            if ()



        }

        Order order = Order.builder()
                .phoneNumber(orderRequest.phoneNumber())
                .address(orderRequest.address())
                .landmark(orderRequest.landmark())
                .comments(orderRequest.comments())
//                .orderNumber
                .build();

        orderRepository.save(order);

    }
}
