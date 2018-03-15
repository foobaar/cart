package com.foobaar.cart.controller;

import com.foobaar.cart.request.UpsertCartRequest;
import com.foobaar.cart.response.GetCartResponse;
import com.foobaar.cart.response.UpsertCartResponse;
import com.foobaar.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService service;

    @Autowired
    public CartController(final CartService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{userId}", method = GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<GetCartResponse> getCart(@PathVariable("userId") final String userId) {
        return ok(service.getCart(userId));
    }

    @RequestMapping(value = "/{userId}", method = DELETE)
    public ResponseEntity<HttpEntity> deleteCart(@PathVariable("userId") final String userId) {
        service.deleteCart(userId);
        return ok(EMPTY);
    }

    @RequestMapping(value = "/{userId}", method = PUT, produces = "application/json;charset=UTF-8")
    public ResponseEntity<UpsertCartResponse> upsertCart(
            @PathVariable("userId") final String userId,
            @RequestBody final UpsertCartRequest request) {
        return ok(service.upsertCart(userId, request));
    }

}
