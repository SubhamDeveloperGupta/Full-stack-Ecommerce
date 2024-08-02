package com.cart.service.cart_service.util;

import com.cart.service.cart_service.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {

    private Integer userId;
    private Product product;

}
