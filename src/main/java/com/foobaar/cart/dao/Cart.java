package com.foobaar.cart.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "carts")
public class Cart {
    private final String cartId;
    private final String userId;
    private final List<CartItem> cartItems;

    public Cart(final String cartId, final List<CartItem> cartItems, final String userId) {
        this.cartId = cartId;
        this.cartItems = cartItems;
        this.userId = userId;
    }

    public String getCartId() {
        return cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public String getUserId() {
        return userId;
    }
}
