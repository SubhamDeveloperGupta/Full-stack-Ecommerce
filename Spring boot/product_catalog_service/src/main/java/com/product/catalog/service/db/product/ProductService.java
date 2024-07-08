package com.product.catalog.service.db.product;


import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.db.Rating;

import java.util.List;

public interface ProductService {

    List<Products> getAllProducts();
    Products getProductsByProductId(Integer productId);

    List<Rating> getProductRatingsByProductId(Integer productId);

    Category getProductsByCategoryId(Integer categoryId);

    Category getProductsByCategoryName(String categoryName);

    Products addProduct(Products product);
    
}
