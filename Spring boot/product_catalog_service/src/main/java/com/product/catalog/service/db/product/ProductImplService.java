package com.product.catalog.service.db.product;


import com.product.catalog.dao.category.CategoryDao;
import com.product.catalog.dao.product.ProductDao;
import com.product.catalog.dao.rating.RatingDao;
import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.db.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Category getProductsByCategoryId(Integer categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }

    @Override
    public Category getProductsByCategoryName(String categoryName) {
        return categoryDao.getCategoryByName(categoryName);
    }


}
