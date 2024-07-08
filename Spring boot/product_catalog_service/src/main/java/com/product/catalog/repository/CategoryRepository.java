package com.product.catalog.repository;

import com.product.catalog.entity.db.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByName(String categoryName);
}
