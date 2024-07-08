package com.product.catalog.dao.category;

import com.product.catalog.entity.db.Category;
import com.product.catalog.exception.CategoryNotFoundException;
import com.product.catalog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryImplDao implements CategoryDao {

    private final CategoryRepository categoryRepository;

    public CategoryImplDao(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return null;
    }

    @Override
    public Boolean existsCategoryByName(String categoryName) {
        return categoryRepository.existsByName(categoryName);
    }

}
