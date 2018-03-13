package com.foobaar.cart.service;

import com.foobaar.cart.client.CartClient;
import com.foobaar.cart.dao.CartItem;
import com.foobaar.cart.dao.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static java.math.BigDecimal.ONE;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class CartServiceTest {
    private CartService sut;
    private CartClient mockClient;
    private CartItem cartItem;
    private Item item;
    private final int quantityCount = 5;
    private String mockId = UUID.randomUUID().toString();

    @Before
    public void setUp() {
        item = new Item(UUID.randomUUID().toString(), "testItem",
                "testDescription", ONE, "testSubCategory");
        cartItem = new CartItem(mockId, item, quantityCount);
        mockClient = mock(CartClient.class);
        sut = new CartService(mockClient);
    }

    @Test
    public void testGetCartHappyPath() {
        when(mockClient.getCart(mockId)).thenReturn(asList(cartItem));
        sut.getCart(mockId);
        verify(mockClient, times(1)).getCart(mockId);
    }

}
