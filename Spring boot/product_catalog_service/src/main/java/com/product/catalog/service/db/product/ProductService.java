package com.product.catalog.service.db.product;


import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.db.Rating;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Products> getAllProducts();
    Products getProductsByProductId(Integer productId);

    List<Rating> getProductRatingsByProductId(Integer productId);

    Set<Products> getProductsByCategoryId(Integer categoryId);

    Set<Products> getProductsByCategoryName(String categoryName);

    Products addProduct(Products product);
    
}
