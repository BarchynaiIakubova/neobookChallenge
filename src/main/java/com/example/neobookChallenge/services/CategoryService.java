package com.example.neobookChallenge.services;

import com.example.neobookChallenge.models.Category;
import com.example.neobookChallenge.repositories.CategoryRepository;
import com.example.neobookChallenge.responses.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {

        return categoryRepository.findAll();
    }
}
