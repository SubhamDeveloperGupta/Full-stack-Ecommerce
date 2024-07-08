package com.product.catalog.dao.product;


import com.product.catalog.entity.db.Products;

import java.util.List;

public interface ProductDao {

    List<Products> getAllProducts();

    Products getProductsByProductId(Integer productId);

}
