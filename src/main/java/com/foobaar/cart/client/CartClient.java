package com.foobaar.cart.client;

import com.foobaar.cart.dao.Cart;
import com.foobaar.cart.exceptions.ApplicationException;
import com.foobaar.cart.exceptions.CartNotFoundException;
import com.foobaar.cart.request.UpsertCartRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CartClient {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CartRepository repository;

    @Autowired
    public CartClient(final CartRepository repository) {
        this.repository = repository;
    }

    public Cart getCart(final String userId) {
        Cart cart;
        try {
             cart =  repository.findByUserId(userId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApplicationException("ReadFromMongoFailed", e);
        }
        return returnOrThrow(cart, userId);
    }
    public void deleteCart(final String id) {
        repository.deleteById(id);
    }

    public Cart upsert(final UpsertCartRequest request) {
        return null;
    }

    private Cart returnOrThrow(final Cart cart, final String userId) {
        if (cart == null) {
            throw new CartNotFoundException(userId);
        }
        return cart;
    }
}
