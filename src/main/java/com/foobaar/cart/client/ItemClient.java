package com.foobaar.cart.client;

import com.foobaar.cart.dao.Item;
import com.foobaar.cart.exceptions.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemClient {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ItemRepository repository;

    @Autowired
    public ItemClient(final ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> findAll() {
        try {
        return repository.findAll();
        } catch (Exception e) {
            log.error("FindItemsFromMongoException", e);
            throw new ApplicationException("", e);
        }
    }
}
