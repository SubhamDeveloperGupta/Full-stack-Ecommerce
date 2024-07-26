package com.product.catalog.repository;

import com.product.catalog.dto.ProductDto;
import com.product.catalog.entity.db.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Query(name = "Products.getProducts", nativeQuery = true)
    List<ProductDto> findAllProducts();

    @Query(name = "Products.findProductById", nativeQuery = true)
    ProductDto findProductById(Integer productId);

    @Query(value = "SELECT COUNT(1) FROM products", nativeQuery = true)
    Long getProductsCount();
}
