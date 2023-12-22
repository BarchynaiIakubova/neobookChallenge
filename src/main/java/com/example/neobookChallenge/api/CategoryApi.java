package com.example.neobookChallenge.api;


import com.example.neobookChallenge.requests.CategoryRequest;
import com.example.neobookChallenge.responses.CategoryResponse;
import com.example.neobookChallenge.responses.Response;
import com.example.neobookChallenge.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@CrossOrigin(origins = "*", originPatterns = "*", maxAge = 5000, exposedHeaders = "Access-Control-Allow-Origin", allowedHeaders = "*")
@Tag(name = "Category API", description = "Category Endpoints")
public class CategoryApi {

    private final CategoryService categoryService;

    @Operation(summary = "Get All", description = "This method gets all categories")
    @GetMapping
    List<CategoryResponse> findAll() {

       return categoryService.findAll();

    }

    @PostMapping
    Response save(@RequestBody CategoryRequest categoryRequest) {

        return categoryService.save(categoryRequest);
    }

    @GetMapping("/{categoryId}")
    CategoryResponse findsById(@PathVariable Long categoryId) {

        return categoryService.findsById(categoryId);
    }

    @PutMapping("/{categoryId}")
    Response update(@PathVariable Long categoryId, CategoryRequest categoryRequest) {

        return categoryService.update(categoryId, categoryRequest);
    }

}
