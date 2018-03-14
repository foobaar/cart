package com.foobaar.cart.response;

public class CreateCartResponse {
    private String id;

    public CreateCartResponse(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

