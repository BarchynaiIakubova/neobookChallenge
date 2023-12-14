package com.example.neobookChallenge.repositories;

import com.example.neobookChallenge.models.Category;
import com.example.neobookChallenge.responses.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("""
               select new com.example.neobookChallenge.responses.CategoryResponse(
               c.id,
               c.title,
               concat(:path, c.image)) from Category c
""")
    List<CategoryResponse> findAllCategories(String path);

}
