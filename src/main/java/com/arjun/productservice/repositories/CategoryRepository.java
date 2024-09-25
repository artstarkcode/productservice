package com.arjun.productservice.repositories;

import com.arjun.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    @Override
    Category save(Category category);
}
