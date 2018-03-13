package com.foobaar.cart.client;

import com.foobaar.cart.dao.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CartClient {
    public List<CartItem> getCart(final String id) {
        return null;
    }

    public String createCart() {
        return null;
    }
}
