package com.foobaar.cart.dao;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CartItem)) {
            return false;
        }
        CartItem cartItem = (CartItem) o;
        return this.item.getId().equals(cartItem.item.getId());
    }

    @Override
    public int hashCode() {
       return Objects.hash(item.getId());
    }
}
