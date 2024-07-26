package com.product.catalog.dao.product;


import com.product.catalog.dto.ProductDto;
import com.product.catalog.entity.db.Products;

import java.util.List;

public interface ProductDao {

    List<ProductDto> getAllProducts();

    Products getProductsByProductId(Integer productId);
    ProductDto getProductByProductId(Integer productId);

    Products addProduct(Products product);

    boolean existsProductByProductId(Integer productId);

    Products updateProduct(Products existingProduct);

    void createListOfProduct(List<Products> collectNewProducts);

    Long getProductsCount();

}
