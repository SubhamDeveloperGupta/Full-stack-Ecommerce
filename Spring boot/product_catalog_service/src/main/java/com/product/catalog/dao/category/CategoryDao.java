package com.product.catalog.dao.category;

import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;

import java.util.List;
import java.util.Set;

public interface CategoryDao {

    Set<Products> getCategoryById(Integer categoryId);

    Set<Products> getProductsByCategoryName(String categoryName);

    Boolean existsCategoryByName(String categoryName);

    Category findCategoryById(Integer categoryId);

    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category updateCategory(Category category);

    boolean existsCategoryById(Integer categoryId);

    Category getCategoryByCategoryName(String category);

    List<Category> saveAllCategoryObject(List<Category> newCategories);

    Long getCategoriesCount();

}
