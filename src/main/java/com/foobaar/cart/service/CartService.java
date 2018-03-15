package com.foobaar.cart.service;

import com.foobaar.cart.client.CartClient;
import com.foobaar.cart.dao.Cart;
import com.foobaar.cart.request.UpsertCartRequest;
import com.foobaar.cart.response.GetCartResponse;
import com.foobaar.cart.response.UpsertCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartService {
    private final CartClient client;

    @Autowired
    public CartService(final CartClient client) {
        this.client = client;
    }

    public GetCartResponse getCart(final String id) {
        return new GetCartResponse(id, client.getCart(id));
    }

    public UpsertCartResponse upsertCart(final UpsertCartRequest request) {
        Cart cart = client.upsert(request);
        return new UpsertCartResponse(cart.getCartId(), cart.getUserId(), cart.getCartItems());
    }

    public void deleteCart(final String id) {

    }
}
