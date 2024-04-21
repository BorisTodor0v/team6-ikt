package com.finki.ikt.team6.repository;

import com.finki.ikt.team6.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
