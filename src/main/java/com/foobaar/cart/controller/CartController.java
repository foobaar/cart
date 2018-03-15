package com.foobaar.cart.controller;

import com.foobaar.cart.request.UpsertCartRequest;
import com.foobaar.cart.response.GetCartResponse;
import com.foobaar.cart.response.UpsertCartResponse;
import com.foobaar.cart.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService service;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CartController(final CartService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{userId}", method = GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<GetCartResponse> getCart(@PathVariable("userId") final String userId) {
        log.info("CartController.getCart: UserId {}", userId);
        return ok(service.getCart(userId));
    }

    @RequestMapping(value = "/{userId}", method = DELETE)
    public ResponseEntity<HttpEntity> deleteCart(@PathVariable("userId")
                                                     final String userId) {
        log.info("CartController.deleteCart: UserId {}", userId);
        service.deleteCart(userId);
        return ok(EMPTY);
    }

    @RequestMapping(method = PUT, consumes = "application/json",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<UpsertCartResponse> upsertCart(
            @Valid @RequestBody final UpsertCartRequest request) {
        log.info("CartController.upsertCart: UserId {}", request.getUserId());
        return ok(service.upsertCart(request));
    }

}
