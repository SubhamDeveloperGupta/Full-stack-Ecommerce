package com.product.catalog.controller;


import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.db.Rating;
import com.product.catalog.service.db.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        return null;
    }

    @GetMapping(params = "productId")
    public ResponseEntity<Products> getProductsByProductId(@RequestParam("productId") Integer productId) {
        return null;
    }

    @GetMapping("/rating/{productId}")
    public ResponseEntity<List<Rating>> getProductRatingsByProductId(@PathVariable("productId") Integer productId) {
        return null;
    }

    @GetMapping(params = "categoryId")
    public ResponseEntity<Category> getProductsByCategoryId(@RequestParam("categoryId") Integer categoryId) {
        return null;
    }

    @GetMapping(params = "categoryName")
    public ResponseEntity<Category> getProductsByCategoryName(@RequestParam("categoryName") String categoryName) {
        return null;
    }



}
