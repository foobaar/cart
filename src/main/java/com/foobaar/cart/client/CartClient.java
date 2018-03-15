package com.foobaar.cart.client;

import com.foobaar.cart.dao.Cart;
import com.foobaar.cart.exceptions.ApplicationException;
import com.foobaar.cart.exceptions.CartNotFoundException;
import com.foobaar.cart.request.UpsertCartRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;

import static java.util.UUID.randomUUID;


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
        Cart cart;
        try {
            cart =  repository.findByUserId(request.getUserId());
            if (cart == null) {
                Cart newCart = createNewCart(request);
                repository.save(newCart);
                return newCart;
            } else {
                return updateAndSave(request, cart);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApplicationException("MongoOpertationFailed", e);
        }
    }

    private Cart updateAndSave(final UpsertCartRequest request, Cart cart) {
        request.getCartItems().stream().forEach(x -> {
            cart.getCartItems().add(x);
        });
        repository.save(cart);
        return cart;

    }

    private Cart createNewCart(final UpsertCartRequest request) {
        return new Cart(randomUUID().toString(), new HashSet<>(request.getCartItems()), request.getUserId());
    }

    private Cart returnOrThrow(final Cart cart, final String userId) {
        if (cart == null) {
            throw new CartNotFoundException(userId);
        }
        return cart;
    }
}
