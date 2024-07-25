package com.product.catalog.service.db.product;


import com.product.catalog.dao.category.CategoryDao;
import com.product.catalog.dao.product.ProductDao;
import com.product.catalog.dao.rating.RatingDao;
import com.product.catalog.dto.ProductDto;
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
    public List<ProductDto> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public ProductDto getProductsByProductId(Integer productId) {
        ProductDto product = productDao.getProductByProductId(productId);
        List<Rating> rating = ratingDao.getProductRatingsByProductId(productId);
        product.setRatingList(rating);
        return product;
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
        return categoryDao.getProductsByCategoryName(categoryName);
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

    @Override
    public Products updateProduct(Integer productId, Products product) {
        Products existingProduct = productDao.getProductsByProductId(productId);
        return createObject(existingProduct, product);
    }

    private Products createObject(Products existingProduct, Products newProduct) {
        if(newProduct.getProductId() == null ||
                !existingProduct.getProductId().equals(newProduct.getProductId()) ||
                newProduct.getCategory().getCategoryId() == null) {
            throw new GlobalException("Product cannot be updated");
        }

        // Set category values
        if(!existingProduct.getCategory().getCategoryId().equals(newProduct.getCategory().getCategoryId())) {
            if(!categoryDao.existsCategoryById(newProduct.getCategory().getCategoryId())) {
                throw new GlobalException("Category does not exist");
            }
            existingProduct.setCategory(newProduct.getCategory());
        }

        // Set Product details
        existingProduct.setProductOwnerName(newProduct.getProductOwnerName());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setTitle(newProduct.getTitle());
        existingProduct.setDescription(newProduct.getDescription());
        existingProduct.setImageUrl(newProduct.getImageUrl());

        return productDao.updateProduct(existingProduct);
    }

}
