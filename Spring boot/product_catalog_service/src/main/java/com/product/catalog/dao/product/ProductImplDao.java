package com.product.catalog.dao.product;


import com.product.catalog.entity.db.Products;
import com.product.catalog.exception.ProductNotFoundException;
import com.product.catalog.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImplDao implements ProductDao {

    private final ProductsRepository productsRepository;

    public ProductImplDao(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products getProductsByProductId(Integer productId) {
        return productsRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Products addProduct(Products product) {
        return productsRepository.save(product);
    }

}
