package com.foobaar.cart.client;

import com.foobaar.cart.dao.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByUserId(String userId);

    void deleteById(String s);
}
