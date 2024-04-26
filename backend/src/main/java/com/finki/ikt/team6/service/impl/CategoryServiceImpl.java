package com.finki.ikt.team6.service.impl;

import com.finki.ikt.team6.model.Category;
import com.finki.ikt.team6.model.exceptions.CategoryAlreadyExistsException;
import com.finki.ikt.team6.model.exceptions.InvalidCategoryIdException;
import com.finki.ikt.team6.repository.CategoryRepository;
import com.finki.ikt.team6.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(InvalidCategoryIdException::new);
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(String name) {
        if(this.categoryRepository.findByName(name).isPresent()){
            throw new CategoryAlreadyExistsException(name);
        }
        Category category = new Category(name);
        return categoryRepository.save(category);
    }
}
