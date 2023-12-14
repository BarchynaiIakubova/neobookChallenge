package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.Category;
import com.example.neobookChallenge.repositories.CategoryRepository;
import com.example.neobookChallenge.responses.CategoryResponse;
import lombok.RequiredArgsConstructor;

//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
}
