package com.foobaar.cart.client;

import com.foobaar.cart.dao.Cart;
import com.foobaar.cart.dao.CartItem;
import com.foobaar.cart.request.UpsertCartRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CartClient {
    public List<CartItem> getCart(final String id) {
        return null;
    }

    public Cart upsert(final String userId, final UpsertCartRequest request) {
        return null;
    }
}
