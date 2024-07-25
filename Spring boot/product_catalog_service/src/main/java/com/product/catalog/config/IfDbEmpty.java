package com.product.catalog.config;

import com.product.catalog.service.db.category.CategoryService;
import com.product.catalog.service.db.product.ProductService;
import com.product.catalog.service.fakestore.FakeStoreService;
import org.springframework.stereotype.Service;

@Service
public class IfDbEmpty {

    private final FakeStoreService fakeStoreService;
    private final ProductService productService;
    private final CategoryService categoryService;

    public IfDbEmpty(FakeStoreService fakeStoreService, ProductService productService, CategoryService categoryService) {
        this.fakeStoreService = fakeStoreService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    public void executeStart() {

    }
}
