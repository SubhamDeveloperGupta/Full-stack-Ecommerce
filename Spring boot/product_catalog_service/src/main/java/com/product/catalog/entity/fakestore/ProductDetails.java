package com.product.catalog.entity.fakestore;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDetails {
    private Integer id;
    private String category;
    private String description;
    private String image;
    private String title;
    private BigDecimal price;

    private Rating rating;
}
