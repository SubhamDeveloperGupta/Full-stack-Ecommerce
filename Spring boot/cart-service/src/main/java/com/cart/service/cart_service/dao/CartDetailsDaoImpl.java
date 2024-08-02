package com.cart.service.cart_service.dao;

import com.cart.service.cart_service.entity.CartDetails;
import com.cart.service.cart_service.entity.Products;
import com.cart.service.cart_service.repository.CartDetailsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDetailsDaoImpl implements CartDetailsDao {

    private final CartDetailsRepository cartDetailsRepository;

    public CartDetailsDaoImpl(CartDetailsRepository cartDetailsRepository) {
        this.cartDetailsRepository = cartDetailsRepository;
    }

    @Override
    public List<CartDetails> getAllCart() {
        return cartDetailsRepository.findAll();
    }

    @Override
    public CartDetails getAllCartsProductByUserId(Integer userId) {
        return cartDetailsRepository.findByUserId(userId);
    }

    @Override
    public CartDetails createCart(CartDetails cartDetails) {
        Integer userId = cartDetails.getUserId();
        if (userId == null) {
            throw new RuntimeException();
        }
        if (cartDetailsRepository.existsByUserId(userId)) {
            // TODO
        }
        // TODO
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

