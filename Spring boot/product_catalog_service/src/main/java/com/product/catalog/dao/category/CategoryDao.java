package com.product.catalog.dao.category;

import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;

import java.util.List;
import java.util.Set;

public interface CategoryDao {

    Set<Products> getCategoryById(Integer categoryId);

    Set<Products> getCategoryByName(String categoryName);

    Boolean existsCategoryByName(String categoryName);


    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category updateCategory(Category category);

    boolean existsCategoryById(Integer categoryId);

}
