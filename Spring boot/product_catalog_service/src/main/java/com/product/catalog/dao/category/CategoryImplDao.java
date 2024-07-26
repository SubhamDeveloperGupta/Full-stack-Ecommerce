package com.product.catalog.dao.category;

import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import com.product.catalog.exception.CategoryNotFoundException;
import com.product.catalog.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class CategoryImplDao implements CategoryDao {

    private final CategoryRepository categoryRepository;

    public CategoryImplDao(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Products> getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new)
                .getProducts();
    }

    @Override
    public Set<Products> getProductsByCategoryName(String categoryName) {
        return categoryRepository.findByName(categoryName)
                .orElseThrow(CategoryNotFoundException::new)
                .getProducts();
    }

    @Override
    public Boolean existsCategoryByName(String categoryName) {
        return categoryRepository.existsByName(categoryName);
    }

    @Override
    public Category findCategoryById(Integer categoryId) {
        return categoryRepository
                .findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean existsCategoryById(Integer categoryId) {
        return categoryRepository.existsById(categoryId);
    }

    @Override
    public Category getCategoryByCategoryName(String category) {
        return categoryRepository
                .findByName(category)
                .orElse(null);
    }

    @Override
    public List<Category> saveAllCategoryObject(List<Category> newCategories) {
        return categoryRepository.saveAll(newCategories);
    }

    @Override
    public Long getCategoriesCount() {
        return categoryRepository.getCategoriesCount();
    }

}
