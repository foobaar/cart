package com.foobaar.cart.response;

import com.foobaar.cart.dao.CartItem;

import java.util.Set;

public class GetCartResponse {
    private final String userId;
    private final Set<CartItem> cartItems;

    public GetCartResponse(final String userId, final Set<CartItem> cartItems) {
        this.cartItems = cartItems;
        this.userId = userId;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public String getUserId() {
        return userId;
    }
}
