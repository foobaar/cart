package com.foobaar.cart.response;

import com.foobaar.cart.dao.CartItem;

import java.util.List;

public class GetCartResponse {
    private final String userId;
    private final List<CartItem> cartItems;

    public GetCartResponse(final String userId, final List<CartItem> cartItems) {
        this.cartItems = cartItems;
        this.userId = userId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public String getUserId() {
        return userId;
    }
}
