package com.foobaar.cart.controller;

import com.foobaar.cart.response.GetCartResponse;
import com.foobaar.cart.service.CartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
@WebAppConfiguration
public class CartControllerIntegrationTest {
    private MockMvc mockMvc;
    private CartService mockService;
    private CartController sut;
    private String id = UUID.randomUUID().toString();
    private String cartId = UUID.randomUUID().toString();

    @Before
    public void setUp() {
        mockService = mock(CartService.class);
        sut = new CartController(mockService);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(sut)
                .build();
    }

    @Test
    public void getCartHappyPath() throws Exception {
        when(mockService.getCart(id)).thenReturn(new GetCartResponse(id, new HashSet<>()));

        mockMvc.perform(get("/cart/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(mockService, times(1)).getCart(id);
        verifyNoMoreInteractions(mockService);
    }

    @Test
    public void deleteCartHappyPath() throws Exception {
        doNothing().when(mockService).deleteCart(id);

        mockMvc.perform(delete("/cart/" + id))
                .andExpect(status().isOk());

        verify(mockService, times(1)).deleteCart(id);
        verifyNoMoreInteractions(mockService);
    }
}


