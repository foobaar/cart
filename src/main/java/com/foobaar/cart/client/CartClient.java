package com.foobaar.cart.client;

import com.foobaar.cart.dao.Cart;
import com.foobaar.cart.request.UpsertCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CartClient {
    private final CartRepository repository;

    @Autowired
    public CartClient(final CartRepository repository) {
        this.repository = repository;
    }

    public Cart getCart(final String userId) {
        return repository.findByUserId(userId);
    }

    public Cart upsert(final UpsertCartRequest request) {
        return null;
    }

    public void deleteCart(String id) {
        repository.deleteById(id);
    }
}
