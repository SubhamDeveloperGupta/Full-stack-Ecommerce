package com.product.catalog.exception;

public class RatingNotFoundException extends RuntimeException {
    public RatingNotFoundException() {
    }

    public RatingNotFoundException(String message) {
        super(message);
    }
}
