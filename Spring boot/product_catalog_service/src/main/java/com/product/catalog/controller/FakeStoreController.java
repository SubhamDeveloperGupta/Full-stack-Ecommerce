package com.product.catalog.controller;

import com.product.catalog.entity.fakestore.ProductDetails;
import com.product.catalog.service.fakestore.FakeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fake-store")
public class FakeStoreController {

    @Autowired
    private FakeStoreService fakeStoreService;

    @GetMapping
    public ResponseEntity<Flux<ProductDetails>> getAllProducts() {
        return new ResponseEntity<>(fakeStoreService.getProductDetails(), HttpStatus.OK);
    }

    @GetMapping(params = "productId")
    public ResponseEntity<Mono<ProductDetails>> getProductDetailsById(@RequestParam("productId") String productId) {
        return new ResponseEntity<>(fakeStoreService.getProductDetailsById(productId), HttpStatus.OK);
    }

    @GetMapping(params = "limit")
    public ResponseEntity<Flux<ProductDetails>> getProductDetailsByLimit(@RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        return new ResponseEntity<>(fakeStoreService.getProductDetailsByLimit(limit), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<Flux<String>> getAllCategories() {
        return new ResponseEntity<>(fakeStoreService.getProductAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<Flux<ProductDetails>> getProductCategoryByCategoryType(@RequestParam("categoryType") String categoryType) {
        return new ResponseEntity<>(fakeStoreService.getProductDetailsByCategory(categoryType), HttpStatus.OK);
    }

}
