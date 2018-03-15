package com.foobaar.cart.response;

import com.foobaar.cart.dao.CartItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResponseUtil {
    public static BigDecimal getTotalValueOfCart(Set<CartItem> cartItems) {
        BigDecimal totalValue = BigDecimal.ZERO;
        if (cartItems == null || cartItems.isEmpty()) {
            return totalValue;
        }
        List<BigDecimal> bigDecimalList = cartItems.stream()
                .map(x -> x.getItem().getUnitPrice().multiply(new BigDecimal(x.getQuantity())))
                .collect(Collectors.toList());
       return bigDecimalList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
