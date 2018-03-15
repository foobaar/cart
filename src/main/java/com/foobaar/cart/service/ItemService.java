package com.foobaar.cart.service;

import com.foobaar.cart.client.ItemClient;
import com.foobaar.cart.dao.Item;
import com.foobaar.cart.response.ItemsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {
    private final ItemClient client;

    @Autowired
    public ItemService(final ItemClient client) {
        this.client = client;
    }

    public ItemsResponse getItems() {
        final List<Item> items = client.findAll();
        return new ItemsResponse(items);
    }
}
