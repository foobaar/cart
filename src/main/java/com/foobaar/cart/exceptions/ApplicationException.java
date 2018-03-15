package com.foobaar.cart.exceptions;


public class ApplicationException extends RuntimeException {
    public ApplicationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
