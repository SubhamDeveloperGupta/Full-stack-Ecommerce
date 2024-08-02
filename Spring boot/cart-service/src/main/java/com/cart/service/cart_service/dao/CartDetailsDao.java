package com.cart.service.cart_service.dao;

import com.cart.service.cart_service.entity.CartDetails;
import com.cart.service.cart_service.entity.Product;

import java.util.List;

public interface CartDetailsDao {

    List<CartDetails> getAllCart();
    CartDetails getAllCartsProductByUserId(Integer userId);
    CartDetails createCart(CartDetails cartDetails);
    CartDetails addNewItemToCart(Integer userId, Product products);
    CartDetails deleteItemFromCart(Integer userId, Integer productId);


    boolean existsByUserId(Integer userId);
    CartDetails decreaseProduct(Integer userId, Integer product);
}
