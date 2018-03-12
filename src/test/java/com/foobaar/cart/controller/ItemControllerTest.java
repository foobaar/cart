package com.foobaar.cart.controller;

import com.foobaar.cart.response.ItemsResponse;
import com.foobaar.cart.service.ItemService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


public class ItemControllerTest {
    private ItemController sut;
    private ItemService mockService;

    @Before
    public void setUp() {
        mockService = mock(ItemService.class);
        sut = new ItemController(mockService);
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testGetItemsHappypath() {
        when(mockService.getItems()).thenReturn(new ItemsResponse(null));
        sut.getItems();
        verify(mockService, times(1)).getItems();
    }
}
