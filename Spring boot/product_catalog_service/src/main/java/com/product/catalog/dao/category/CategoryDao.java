package com.product.catalog.dao.category;

import com.product.catalog.entity.db.Category;

public interface CategoryDao {

    Category getCategoryById(Integer categoryId);

    Category getCategoryByName(String categoryName);

}
