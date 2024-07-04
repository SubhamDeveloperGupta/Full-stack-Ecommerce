package com.product.catalog.repository;

import com.product.catalog.entity.db.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
