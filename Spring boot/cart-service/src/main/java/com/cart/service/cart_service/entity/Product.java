package com.cart.service.cart_service.entity;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer productId;
    private String description;
    private String imageUrl;
    private String title;
    private BigDecimal price;
    private String productOwnerName;

}
