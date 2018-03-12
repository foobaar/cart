package com.foobaar.cart.controller;

import com.foobaar.cart.response.ItemsResponse;
import com.foobaar.cart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService service;

    @Autowired
    public ItemController(final ItemService service) {
        this.service = service;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<ItemsResponse> getItems() {
        return ok(service.getItems());
    }

}

