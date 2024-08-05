package com.cart.service.cart_service.service;

import com.cart.service.cart_service.entity.CartDetails;
import com.cart.service.cart_service.entity.Product;
import com.cart.service.cart_service.util.CartRequest;

import java.util.List;

public interface CartDetailsService {

    List<CartDetails> getAllCart();
    CartDetails getAllCartsProductByUserId(Integer userId);
    CartDetails createCart(CartRequest request);
    CartDetails addNewItemToCart(Integer userId, Product products);

    CartDetails decreaseProduct(Integer userId, Product product);
}
