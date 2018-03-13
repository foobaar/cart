package com.foobaar.cart.controller;

import com.foobaar.cart.response.GetCartResponse;
import com.foobaar.cart.service.CartService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


public class CartControllerTest {
    private CartController sut;
    private CartService mockService;
    private String mockId = UUID.randomUUID().toString();

    @Before
    public void setUp() {
        mockService = mock(CartService.class);
        sut = new CartController(mockService);
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testGetCartHappypath() {
        when(mockService.getCart(mockId)).thenReturn(new GetCartResponse(mockId, null));
        sut.getCart(mockId);
        verify(mockService, times(1)).getCart(mockId);
    }
}
