package com.example.neobookChallenge.api;


import com.example.neobookChallenge.responses.CategoryResponse;
import com.example.neobookChallenge.services.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "Category API", description = "Category Endpoints")
public class CategoryApi {

    private final CategoryService categoryService;

    @GetMapping
    List<CategoryResponse> findAll() {

       return categoryService.findAll();

    }


}
