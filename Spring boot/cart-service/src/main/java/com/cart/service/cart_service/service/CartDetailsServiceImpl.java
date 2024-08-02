package com.cart.service.cart_service.service;

import com.cart.service.cart_service.dao.CartDetailsDao;
import com.cart.service.cart_service.entity.CartDetails;
import com.cart.service.cart_service.entity.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

    private final CartDetailsDao cartDetailsDao;

    public CartDetailsServiceImpl(CartDetailsDao cartDetailsDao) {
        this.cartDetailsDao = cartDetailsDao;
    }

    @Override
    public List<CartDetails> getAllCart() {
        return null;
    }

    @Override
    public CartDetails getAllCartsProductByUserId(Integer userId) {
        return null;
    }

    @Override
    public CartDetails createCart(CartDetails cartDetails) {
        return null;
    }

    @Override
    public CartDetails addNewItemToCart(Integer userId, Products products) {
        return null;
    }

    @Override
    public CartDetails deleteItemFromCart(Integer userId, Integer productId) {
        return null;
    }
}
