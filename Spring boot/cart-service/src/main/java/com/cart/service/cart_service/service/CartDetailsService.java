package com.cart.service.cart_service.service;

import com.cart.service.cart_service.entity.CartDetails;
import com.cart.service.cart_service.entity.Products;

import java.util.List;

public interface CartDetailsService {

    List<CartDetails> getAllCart();
    CartDetails getAllCartsProductByUserId(Integer userId);
    CartDetails createCart(CartDetails cartDetails);
    CartDetails addNewItemToCart(Integer userId, Products products);
    CartDetails deleteItemFromCart(Integer userId, Integer productId);

}
