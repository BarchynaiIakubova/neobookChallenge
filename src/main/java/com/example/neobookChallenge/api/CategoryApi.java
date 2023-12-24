package com.example.neobookChallenge.api;


import com.example.neobookChallenge.requests.CategoryRequest;
import com.example.neobookChallenge.requests.CategoryRequestMultipart;
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

    @GetMapping
    @Operation(summary = "Get All", description = "This method gets all categories")
    List<CategoryResponse> findAll() {

       return categoryService.findAll();

    }

    @PostMapping
    @Operation(summary = "Save Category", description = "This method saves category")
    Response save(@RequestBody CategoryRequest categoryRequest) {

        return categoryService.save(categoryRequest);
    }

    @GetMapping("/{categoryId}")
    @Operation(summary = "Get by Id", description = "This method gets category by Id")
    CategoryResponse findsById(@PathVariable Long categoryId) {

        return categoryService.findsById(categoryId);
    }

    @PutMapping("/{categoryId}")
    @Operation(summary = "Update Category", description = "This method updates category by id")
    Response update(@PathVariable Long categoryId, CategoryRequest categoryRequest) {

        return categoryService.update(categoryId, categoryRequest);
    }

    @DeleteMapping("/{categoryId}")
    @Operation(summary = "Delete by Id", description = "This method deletes category by Id")
    Response delete(@PathVariable Long categoryId) {

        return categoryService.delete(categoryId);
    }

}
