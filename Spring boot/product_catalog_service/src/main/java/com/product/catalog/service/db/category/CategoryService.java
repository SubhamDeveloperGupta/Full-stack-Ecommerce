package com.product.catalog.service.db.category;


import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    List<Category> getAllCategories();
    Set<Products> getCategoryById(Integer id);
    Category createCategory(Category category);
    Category updateCategory(Category category);

}
