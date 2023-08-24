package com.payetonkawa.payetonkawa.customers;

import com.payetonkawa.payetonkawa.customers.Customers;
import com.payetonkawa.payetonkawa.customers.CustomersController;
import com.payetonkawa.payetonkawa.customers.ICustomersService;
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

class CustomersControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ICustomersService customersService;

    @InjectMocks
    private CustomersController customersController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customersController).build();
    }

    @Test
    void getAllCustomers() throws Exception {
        Customers customer = new Customers();
        when(customersService.getAllCustomers()).thenReturn(Collections.singletonList(customer));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(customersService, times(1)).getAllCustomers();
    }

    @Test
    void createCustomers() throws Exception {
        Customers customer = new Customers();
        when(customersService.createCustomer(any())).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(customersService, times(1)).createCustomer(any());
    }

    @Test
    void deleteCustomer() throws Exception {
        UUID customerId = UUID.randomUUID();

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/customers/" + customerId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(customersService, times(1)).deleteCustomer(customerId);
    }
}