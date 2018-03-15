package com.foobaar.cart.response;

import com.foobaar.cart.dao.CartItem;

import java.math.BigDecimal;
import java.util.Set;

import static com.foobaar.cart.response.ResponseUtil.getTotalValueOfCart;

public class GetCartResponse {
    private final String userId;
    private final Set<CartItem> cartItems;
    private BigDecimal totalValue;

    public GetCartResponse(final String userId, final Set<CartItem> cartItems) {
        this.cartItems = cartItems;
        this.userId = userId;
        this.totalValue = getTotalValueOfCart(cartItems);
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }
}
