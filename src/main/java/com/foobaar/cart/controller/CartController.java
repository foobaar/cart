package com.foobaar.cart.controller;

import com.foobaar.cart.response.CreateCartResponse;
import com.foobaar.cart.response.GetCartResponse;
import com.foobaar.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService service;

    @Autowired
    public CartController(final CartService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<GetCartResponse> getCart(@PathVariable("id") final String id) {
        return ok(service.getCart(id));
    }

    @RequestMapping(value = "/create", method = POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<CreateCartResponse> createCart() {
        return ok(service.createCart());
    }
}
