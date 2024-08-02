package com.cart.service.cart_service.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found exception");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
