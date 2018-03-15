package com.foobaar.cart.request;

import com.foobaar.cart.dao.CartItem;

import java.util.List;

public class UpsertCartRequest {
    private final String userId;
    private final List<CartItem> cartItems;

    public UpsertCartRequest(final String userId, final List<CartItem> cartItems) {
        this.userId = userId;
        this.cartItems = cartItems;
    }

    public String getUserId() {
        return userId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
