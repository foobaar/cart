package com.foobaar.cart.request;

import com.foobaar.cart.dao.CartItem;

import java.util.List;

public class UpsertCartRequest {
    private final String userId;
    private final String cartId;
    private final List<CartItem> cartItems;

    public UpsertCartRequest(final String userId, final String cartId, final List<CartItem> cartItems) {
        this.userId = userId;
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public String getUserId() {
        return userId;
    }

    public String getCartId() {
        return cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
