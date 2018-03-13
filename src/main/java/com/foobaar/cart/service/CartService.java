package com.foobaar.cart.service;

import com.foobaar.cart.client.CartClient;
import com.foobaar.cart.response.CreateCartResponse;
import com.foobaar.cart.response.GetCartResponse;
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

    public CreateCartResponse createCart() {
        String id = client.createCart();
        return new CreateCartResponse(id);
    }
}
