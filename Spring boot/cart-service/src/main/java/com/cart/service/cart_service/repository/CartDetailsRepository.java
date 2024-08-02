package com.cart.service.cart_service.repository;

import com.cart.service.cart_service.entity.CartDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartDetailsRepository extends MongoRepository<CartDetails, String> {
    CartDetails findByUserId(Integer userId);

    boolean existsByUserId(Integer userId);

}
