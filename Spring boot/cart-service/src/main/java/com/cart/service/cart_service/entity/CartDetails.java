package com.cart.service.cart_service.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
@Document
public class CartDetails {

    @Id
    @GeneratedValue
    private Integer userId;

    @Column(name = "map_products")
    private Map<Integer, List<Products>> productsMap;

}
