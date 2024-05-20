package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);
    List<Category> listAll();
    Category create(String name);
}
