package com.finki.ikt.team6.controller.rest;

import com.finki.ikt.team6.model.Category;
import com.finki.ikt.team6.model.exceptions.CategoryAlreadyExistsException;
import com.finki.ikt.team6.model.exceptions.InvalidCategoryIdException;
import com.finki.ikt.team6.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> listAllCategories(){
        return this.categoryService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            Category category = this.categoryService.findById(id);
            return new ResponseEntity<>(category, HttpStatus.FOUND);
        } catch (InvalidCategoryIdException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam String name){
        try{
            Category category = this.categoryService.create(name);
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        } catch (CategoryAlreadyExistsException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }
}
