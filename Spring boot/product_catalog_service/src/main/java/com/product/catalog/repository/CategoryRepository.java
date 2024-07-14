package com.product.catalog.repository;

import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByName(String categoryName);

    Optional<Category> findByName(String categoryName);
}
