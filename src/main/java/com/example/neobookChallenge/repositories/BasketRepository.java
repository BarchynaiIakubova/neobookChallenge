package com.example.neobookChallenge.repositories;

import com.example.neobookChallenge.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<OrderProduct, Long> {

}
