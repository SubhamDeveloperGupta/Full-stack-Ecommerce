package com.cart.service.cart_service.repository;

import com.cart.service.cart_service.entity.CartDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartDetailsRepository extends MongoRepository<CartDetails, String> {
    Optional<CartDetails> findByUserId(Integer userId);

    boolean existsByUserId(Integer userId);

}
