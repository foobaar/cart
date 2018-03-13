package com.foobaar.cart.response;

import com.foobaar.cart.dao.CartItem;

import java.util.List;

public class GetCartResponse {
    private final String cartId;
    private final List<CartItem> cartItems;

    public GetCartResponse(final String cartId, final List<CartItem> cartItems) {
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public String getCartId() {
        return cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
