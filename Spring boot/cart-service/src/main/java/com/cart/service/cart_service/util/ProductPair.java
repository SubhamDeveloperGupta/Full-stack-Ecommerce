package com.cart.service.cart_service.util;

import com.cart.service.cart_service.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPair {
    private Product products;
    private Integer count;
}
