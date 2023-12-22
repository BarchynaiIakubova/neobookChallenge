package com.example.neobookChallenge.repositories;

import com.example.neobookChallenge.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
