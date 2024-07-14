package com.product.catalog.service.db.product;


import com.product.catalog.dao.category.CategoryDao;
import com.product.catalog.dao.product.ProductDao;
import com.product.catalog.dao.rating.RatingDao;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.db.Rating;
import com.product.catalog.exception.GlobalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductImplService implements ProductService {

    private final CategoryDao categoryDao;
    private final RatingDao ratingDao;
    private final ProductDao productDao;

    public ProductImplService(CategoryDao categoryDao, RatingDao ratingDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.ratingDao = ratingDao;
        this.productDao = productDao;
    }

    @Override
    public List<Products> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public Products getProductsByProductId(Integer productId) {
        return productDao.getProductsByProductId(productId);
    }

    @Override
    public List<Rating> getProductRatingsByProductId(Integer productId) {
        return ratingDao.getProductRatingsByProductId(productId);
    }

    @Override
    public Set<Products> getProductsByCategoryId(Integer categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }

    @Override
    public Set<Products> getProductsByCategoryName(String categoryName) {
        return categoryDao.getCategoryByName(categoryName);
    }

    @Override
    public Products addProduct(Products product) {

        if(product.getCategory() == null ||
                product.getCategory().getCategoryId() == null ||
                !categoryDao.existsCategoryById(product.getCategory().getCategoryId())) {
            throw new GlobalException("Category does not exist");
        }

        Products newObject = productDao.addProduct(product);
        return newObject;
    }

}
