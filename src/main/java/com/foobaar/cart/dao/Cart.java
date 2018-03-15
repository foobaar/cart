package com.foobaar.cart.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "carts")
public class Cart {
    private final String cartId;
    private final String userId;
    private final Set<CartItem> cartItems;

    public Cart(final String cartId, final Set<CartItem> cartItems, final String userId) {
        this.cartId = cartId;
        this.cartItems = cartItems;
        this.userId = userId;
    }

    public String getCartId() {
        return cartId;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public String getUserId() {
        return userId;
    }
}
