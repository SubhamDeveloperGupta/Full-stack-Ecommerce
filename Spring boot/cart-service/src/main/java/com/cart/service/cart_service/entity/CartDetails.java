package com.cart.service.cart_service.entity;


import com.cart.service.cart_service.util.ProductPair;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CartDetails {

    @MongoId
    private String id;

//    @Column(unique = true)
    private Integer userId;

//    @Column(name = "map_products")
    private Map<Integer, ProductPair> productsMap;

}
