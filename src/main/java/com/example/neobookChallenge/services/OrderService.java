package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.Order;
import com.example.neobookChallenge.repositories.OrderRepository;
import com.example.neobookChallenge.requests.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public String save(OrderRequest orderRequest) {

        Random random = new Random();
        Long orderNumber;

        Long generatedNumber;
        List<Order> orders = orderRepository.findAll();



        do {
            generatedNumber = random.nextLong(100000000, 999999999);
            System.out.println("Generated random Number is = " + generatedNumber);

            boolean found = false;

            for (Order order : orders) {
                System.out.println("Order number is " + order.getOrderNumber());
                if (generatedNumber.equals(order.getOrderNumber())) {
                    System.out.println("");
                    found = true;
                    break;
                }
            }

            if (!found) {
                orderNumber = generatedNumber;
                break;
            }
        } while (true);

        Order order = Order.builder()
                .phoneNumber(orderRequest.phoneNumber())
                .address(orderRequest.address())
                .landmark(orderRequest.landmark())
                .comments(orderRequest.comments())
                .orderNumber(orderNumber)
                .build();

        orderRepository.save(order);

        return "Order number is " + orderNumber;
    }
}
