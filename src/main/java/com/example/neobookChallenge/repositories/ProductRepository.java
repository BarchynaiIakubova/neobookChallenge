package com.example.neobookChallenge.repositories;

import com.example.neobookChallenge.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
