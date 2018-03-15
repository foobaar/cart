package com.foobaar.cart.controller;

import com.foobaar.cart.response.ItemsResponse;
import com.foobaar.cart.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ItemService service;

    @Autowired
    public ItemController(final ItemService service) {
        this.service = service;
    }

    @RequestMapping(method = GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<ItemsResponse> getItems() {
        log.info("ItemController.getItems");
        return ok(service.getItems());
    }
}

