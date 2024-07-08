package com.product.catalog.controller;


import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.db.Rating;
import com.product.catalog.service.db.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(params = "productId")
    public ResponseEntity<Products> getProductsByProductId(@RequestParam("productId") Integer productId) {
        return new ResponseEntity<>(productService.getProductsByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("/rating/{productId}")
    public ResponseEntity<List<Rating>> getProductRatingsByProductId(@PathVariable("productId") Integer productId) {
        return new ResponseEntity<>(productService.getProductRatingsByProductId(productId), HttpStatus.OK);
    }

    @GetMapping(params = "categoryId")
    public ResponseEntity<Category> getProductsByCategoryId(@RequestParam("categoryId") Integer categoryId) {
        return new ResponseEntity<>(productService.getProductsByCategoryId(categoryId), HttpStatus.OK);
    }

    @GetMapping(params = "categoryName")
    public ResponseEntity<Category> getProductsByCategoryName(@RequestParam("categoryName") String categoryName) {
        return new ResponseEntity<>(productService.getProductsByCategoryName(categoryName), HttpStatus.OK);
    }



}
