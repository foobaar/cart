package com.foobaar.cart.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "carts")
public class Cart {
    @Id
    private String id;
    private String cartId;
    private String userId;
    private Set<CartItem> cartItems;

    public Cart(final String cartId, final Set<CartItem> cartItems, final String userId) {
        this.cartId = cartId;
        this.cartItems = cartItems;
        this.userId = userId;
    }

    public Cart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
