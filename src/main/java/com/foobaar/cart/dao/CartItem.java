package com.foobaar.cart.dao;

public class CartItem {
    private String cartId;
    private Item item;
    private int quantity;

    public CartItem(final String cartId, final Item item, final int quantity) {
        this.cartId = cartId;
        this.item = item;
        this.quantity = quantity;
    }

    public String getCartId() {
        return cartId;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
