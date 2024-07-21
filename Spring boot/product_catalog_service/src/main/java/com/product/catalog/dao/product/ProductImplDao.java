package com.product.catalog.dao.product;


import com.product.catalog.dto.ProductDto;
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
    public List<ProductDto> getAllProducts() {
        return productsRepository.findAllProducts();
    }

    @Override
    public Products getProductsByProductId(Integer productId) {
        return productsRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
    }


    public ProductDto getProductByProductId(Integer productId) {
        return productsRepository.findProductById(productId);
    }

    @Override
    public Products addProduct(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public boolean existsProductByProductId(Integer productId) {
        return productsRepository.existsById(productId);
    }

}
