package com.example.neobookChallenge.repositories;

import com.example.neobookChallenge.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
