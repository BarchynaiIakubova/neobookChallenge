package com.example.neobookChallenge.repositories;

import com.example.neobookChallenge.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
