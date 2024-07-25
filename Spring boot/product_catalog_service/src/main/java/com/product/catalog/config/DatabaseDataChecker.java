package com.product.catalog.config;

import com.product.catalog.dao.category.CategoryDao;
import com.product.catalog.dao.product.ProductDao;
import com.product.catalog.dto.ProductDto;
import com.product.catalog.entity.db.Category;
import com.product.catalog.entity.db.Products;
import com.product.catalog.entity.fakestore.ProductDetails;
import com.product.catalog.service.fakestore.FakeStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DatabaseDataChecker {

    private final FakeStoreService fakeStoreService;
    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    private final String PRODUCT_OWNER_NAME = "Test";

    public DatabaseDataChecker(FakeStoreService fakeStoreService, ProductDao productDao, CategoryDao categoryDao) {
        this.fakeStoreService = fakeStoreService;
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    public void executeStart() {
        if(isDbEmpty()) {
            Flux<ProductDetails> productDetailsFlux = gettingDataFromFakeStore();
            Mono<List<ProductDetails>> listMono = productDetailsFlux.collectList();
            List<ProductDetails> listProductDetails = listMono.blockOptional().orElse(null);
            if(listProductDetails == null) {
                log.error("Error : Object is Null From");
                return;
            }

            List<Category> saveCategory = createObjectListOfCategory(listProductDetails);
            Map<String, Category> map = new ConcurrentHashMap<>();
            for(Category category : saveCategory) {
                map.put(category.getName(), category);
            }
            log.info("All Categories Have Created...");
            createProducts(listProductDetails,map);

            log.info("Created New Products in Db...");
        }
    }

    private void createProducts(List<ProductDetails> productDetails, Map<String, Category> map) {
        List<Products> collectNewProducts = productDetails
                .stream()
                .parallel()
                .map(obj -> {
                    Products product = new Products();
                    // Set Category
                    if (map.containsKey(obj.getCategory())) {
                        product.setCategory(map.get(obj.getCategory()));
                    } else {
                        obj.getCategory();
                    }

                    // Set Other values
                    product.setDescription(obj.getDescription());
                    product.setImageUrl(obj.getImage());
                    product.setTitle(obj.getTitle());
                    product.setPrice(obj.getPrice());
                    product.setProductOwnerName(PRODUCT_OWNER_NAME);

                    return product;
                })
                .toList();

        productDao.createListOfProduct(collectNewProducts);
    }

    private List<Category> createObjectListOfCategory(List<ProductDetails> list) {
        Set<String> categoryName = list.stream()
                .map(ProductDetails::getCategory)
                .collect(Collectors.toSet());

        List<Category> newCategories = new ArrayList<>();
        for(String name : categoryName) {
            if(!categoryDao.existsCategoryByName(name)) {
                Category category = new Category();
                category.setName(name);
                newCategories.add(category);
            }
        }

        return categoryDao.saveAllCategoryObject(newCategories);
    }

    private Flux<ProductDetails> gettingDataFromFakeStore() {
        return fakeStoreService.getProductDetails();
    }

    private boolean isDbEmpty() {
        List<ProductDto> getAll = productDao.getAllProducts();
        if(getAll.isEmpty()) {
            return true;
        }
        return false;
    }

}
