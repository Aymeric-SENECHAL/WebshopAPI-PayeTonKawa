package com.payetonkawa.payetonkawa.customers;

import com.payetonkawa.payetonkawa.customers.Customers;
import com.payetonkawa.payetonkawa.customers.CustomersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomersServiceImplTest {

    @Mock
    private CustomersRepository customersRepository;

    @InjectMocks
    private CustomersServiceImpl customersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllCustomers() {
        List<Customers> customerList = new ArrayList<>();
        when(customersRepository.findAll()).thenReturn(customerList);

        List<Customers> result = customersService.getAllCustomers();

        assertEquals(customerList, result);
        verify(customersRepository, times(1)).findAll();
    }

    @Test
    void createCustomer() {
        Customers customer = new Customers();
        when(customersRepository.save(customer)).thenReturn(customer);

        Customers result = customersService.createCustomer(customer);

        assertEquals(customer, result);
        verify(customersRepository, times(1)).save(customer);
    }

    @Test
    void deleteCustomer() {
        UUID customerId = UUID.randomUUID();
        doNothing().when(customersRepository).deleteById(customerId);

        assertDoesNotThrow(() -> customersService.deleteCustomer(customerId));
        verify(customersRepository, times(1)).deleteById(customerId);
    }
}