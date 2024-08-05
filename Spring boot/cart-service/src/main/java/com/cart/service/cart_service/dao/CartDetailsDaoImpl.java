package com.cart.service.cart_service.dao;

import com.cart.service.cart_service.entity.CartDetails;
import com.cart.service.cart_service.exceptions.UserNotFoundException;
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
        return cartDetailsRepository
                .findByUserId(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public CartDetails createCart(CartDetails cartObj) {
        return cartDetailsRepository.save(cartObj);
    }

    @Override
    public CartDetails addNewItemToCart(CartDetails cartObj) {
        return cartDetailsRepository.save(cartObj);
    }

    @Override
    public boolean existsByUserId(Integer userId) {
        return cartDetailsRepository.existsByUserId(userId);
    }

    @Override
    public CartDetails decreaseProduct(CartDetails cartDetails) {
        return cartDetailsRepository.save(cartDetails);
    }

}

