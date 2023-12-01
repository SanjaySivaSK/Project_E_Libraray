package com.restapi.service;

import com.restapi.dto.CategoryDto;
import com.restapi.model.Category;
import com.restapi.repository.CategoryRepository;
import com.restapi.request.CategoryRequest;
import com.restapi.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.valueOf;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryDto categoryDto;

    public CategoryResponse findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryDto.mapToCategoryResponse(categories);
    }
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category = categoryDto.mapToCategory(categoryRequest);
        categoryRepository.save(category);
        return findAll();
    }

    public CategoryResponse update(CategoryRequest categoryRequest) {
        Category category = categoryDto.mapToCategory(categoryRequest);
        categoryRepository.save(category);
        return findAll();
    }

    public CategoryResponse deleteById(Integer id) {
        categoryRepository.deleteById(Long.valueOf(id));
        return findAll();
    }


}