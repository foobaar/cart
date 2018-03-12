package com.foobaar.cart.controller;

import com.foobaar.cart.response.ItemsResponse;
import com.foobaar.cart.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
@WebAppConfiguration
public class ItemControllerIntegrationTest {
    private MockMvc mockMvc;
    private ItemService mockService;
    private ItemController sut;

    @Before
    public void setUp() {
        mockService = mock(ItemService.class);
        sut = new ItemController(mockService);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(sut)
                .build();
    }

    @Test
    public void findAllTest() throws Exception {
        when(mockService.getItems()).thenReturn(new ItemsResponse(new ArrayList<>()));

        mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(mockService, times(1)).getItems();
        verifyNoMoreInteractions(mockService);
    }
}
