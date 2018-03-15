package com.foobaar.cart.dao;

public class CartItem {
    private final int quantity;
    private final Item item;

    public CartItem(final Item item, final int quantity) {
        this.quantity = quantity;
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }
}
