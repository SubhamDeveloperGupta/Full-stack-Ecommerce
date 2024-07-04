package com.product.catalog.entity.fakestore;


import lombok.Data;

@Data
public class ProductDetails {
    private Integer id;
    private String category;
    private String description;
    private String image;
    private String title;
    private Double price;

    private Rating rating;
}
