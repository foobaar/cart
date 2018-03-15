package com.foobaar.cart.response;

import com.foobaar.cart.dao.CartItem;

import java.math.BigDecimal;
import java.util.Set;

import static com.foobaar.cart.response.ResponseUtil.getTotalValueOfCart;

public class UpsertCartResponse {
    private final String cartId;
    private final String userId;
    private final Set<CartItem> cartItems;
    private BigDecimal totalValue;

    public UpsertCartResponse(final String cartId, final String userId, final Set<CartItem> cartItems) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItems = cartItems;
        this.totalValue = getTotalValueOfCart(cartItems);
    }



    public String getCartId() {
        return cartId;
    }

    public String getUserId() {
        return userId;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }
}

