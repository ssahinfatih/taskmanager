package com.fatihsahin.taskmanager.service;

import com.fatihsahin.taskmanager.entity.Category;
import com.fatihsahin.taskmanager.repository.CategoryRepository;
import com.fatihsahin.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }


}
