package com.foobaar.cart.response;

import com.foobaar.cart.dao.Item;

import java.util.List;

public class ItemsResponse {
    private final List<Item> item;
    private final int count;

    public ItemsResponse(final List<Item> item) {
        this.item = item;
        this.count = (item != null) ? item.size() : 0;
    }

    public List<Item> getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }
}
