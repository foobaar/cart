package com.foobaar.cart.exceptions;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(final String message) {
        super(message);
    }
}
