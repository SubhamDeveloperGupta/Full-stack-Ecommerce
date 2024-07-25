package com.product.catalog.controller;


import com.product.catalog.dto.ProductDto;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.db.Rating;
import com.product.catalog.service.db.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(params = "productId")
    public ResponseEntity<ProductDto> getProductsByProductId(@RequestParam("productId") Integer productId) {
        return new ResponseEntity<>(productService.getProductsByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("/rating/{productId}")
    public ResponseEntity<List<Rating>> getProductRatingsByProductId(@PathVariable("productId") Integer productId) {
        return new ResponseEntity<>(productService.getProductRatingsByProductId(productId), HttpStatus.OK);
    }

    @GetMapping(params = "categoryId")
    public ResponseEntity<Set<Products>> getProductsByCategoryId(@RequestParam("categoryId") Integer categoryId) {
        return new ResponseEntity<>(productService.getProductsByCategoryId(categoryId), HttpStatus.OK);
    }

    @GetMapping(params = "categoryName")
    public ResponseEntity<Set<Products>> getProductsByCategoryName(@RequestParam("categoryName") String categoryName) {
        return new ResponseEntity<>(productService.getProductsByCategoryName(categoryName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody Products product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Products> updateProduct(@RequestParam Integer productId,
                                                  @RequestBody Products product) {
        return new ResponseEntity<>(productService.updateProduct(productId, product), HttpStatus.OK);
    }

}
