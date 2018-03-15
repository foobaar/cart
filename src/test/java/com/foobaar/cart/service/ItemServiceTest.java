package com.foobaar.cart.service;

import com.foobaar.cart.client.ItemClient;
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

public class ItemServiceTest {
    private ItemService sut;
    private ItemClient mockClient;
    private Item testItem;

    @Before
    public void setUp() {
        testItem = new Item(UUID.randomUUID().toString(), "testItem",
                "testDescription", ONE, "testSubCategory");
        mockClient = mock(ItemClient.class);
        sut = new ItemService(mockClient);
    }

    @Test
    public void testGetItemsHappyPath() {
        when(mockClient.findAll()).thenReturn(asList(testItem));
        sut.getItems();
        verify(mockClient, times(1)).findAll();
    }
}
