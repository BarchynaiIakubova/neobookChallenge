package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.NotFoundException;
import com.example.neobookChallenge.models.Category;
import com.example.neobookChallenge.repositories.CategoryRepository;
import com.example.neobookChallenge.requests.CategoryRequest;
import com.example.neobookChallenge.responses.CategoryResponse;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;

//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Value("${cloud.aws.bucket.path}")
    private String path;

    public List<CategoryResponse> findAll() {

        return categoryRepository.findAllCategories(path);
    }


    public Response save(CategoryRequest categoryRequest) {

        Category category = Category.builder()
                .title(categoryRequest.title())
                .image(categoryRequest.image().substring(path.length()))
                .build();

        categoryRepository.save(category);

        return new Response("Category saved successfully");
    }


    public CategoryResponse findsById(Long categoryId) {

        return categoryRepository.findsById(path, categoryId);

    }


    public Category findByIdCategory(Long categoryId) {

       return categoryRepository.findById(categoryId)
               .orElseThrow(() -> new NotFoundException("The category is not found"));
    }

    @Transactional
    public Response update(Long categoryId, CategoryRequest categoryRequest) {

        Category category = findByIdCategory(categoryId);

        category.setTitle(categoryRequest.title());

        category.setImage(categoryRequest.image());

        return new Response("Category successfully updated");
    }


}
