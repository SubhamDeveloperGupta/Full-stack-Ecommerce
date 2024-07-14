package com.product.catalog.service.db.category;

import com.product.catalog.dao.category.CategoryDao;
import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import com.product.catalog.exception.CategoryNotFoundException;
import com.product.catalog.exception.GlobalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public Set<Products> getCategoryById(Integer id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryDao.createCategory(createObject(category));
    }

    private Category createObject(Category category) {
        if(category.getCategoryId() != null)
            throw new GlobalException("Category id should not be present while create category");
        if (category.getName() != null && categoryDao.existsCategoryByName(category.getName())) {
            throw new GlobalException("Category name already exists");
        }
        return category;
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryDao.updateCategory(updateObject(category));
    }

    private Category updateObject(Category category) {
        if(category.getCategoryId() == null) {
            throw new CategoryNotFoundException();
        }
        if(categoryDao.existsCategoryByName(category.getName())) {
            throw new GlobalException("Category name does not exist");
        }

        return category;
    }

}
