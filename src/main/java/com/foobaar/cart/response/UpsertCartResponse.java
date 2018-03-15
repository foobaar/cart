package com.foobaar.cart.response;

import com.foobaar.cart.dao.CartItem;

import java.util.Set;

public class UpsertCartResponse {
    private final String cartId;
    private final String userId;
    private final Set<CartItem> cartItems;

    public UpsertCartResponse(final String cartId, final String userId, final Set<CartItem> cartItems) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItems = cartItems;
    }

    public String getCartId() {
        return cartId;
    }

    public String getUserId() {
        return userId;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }
}

