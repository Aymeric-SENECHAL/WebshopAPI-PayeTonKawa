package com.payetonkawa.payetonkawa.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrdersControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IOrdersService ordersService;

    @InjectMocks
    private OrdersController ordersController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ordersController).build();
    }

    @Test
    void getAllOrders() throws Exception {
        Orders order = new Orders();
        when(ordersService.getAllOrders()).thenReturn(Collections.singletonList(order));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/orders"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(ordersService, times(1)).getAllOrders();
    }

    @Test
    void getOrdersByCustomersID() throws Exception {
        UUID customersID = UUID.randomUUID();
        Orders order = new Orders();
        when(ordersService.getOrdersByCustomersID(customersID)).thenReturn(Collections.singletonList(order));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers/" + customersID + "/orders"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(ordersService, times(1)).getOrdersByCustomersID(customersID);
    }

    @Test
    void createOrders() throws Exception {
        Orders order = new Orders();
        when(ordersService.createOrders(any())).thenReturn(order);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(ordersService, times(1)).createOrders(any());
    }

    @Test
    void deleteOrders() throws Exception {
        UUID ordersId = UUID.randomUUID();

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/orders/" + ordersId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(ordersService, times(1)).deleteOrders(ordersId);
    }
}
