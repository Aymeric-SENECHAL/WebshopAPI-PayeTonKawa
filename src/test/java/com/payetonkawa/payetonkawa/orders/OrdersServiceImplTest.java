package com.payetonkawa.payetonkawa.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrdersServiceImplTest {

    @Mock
    private OrdersRepository ordersRepository;

    @InjectMocks
    private OrdersServiceImpl ordersService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllOrders() {
        List<Orders> orderList = new ArrayList<>();
        when(ordersRepository.findAll()).thenReturn(orderList);

        List<Orders> result = ordersService.getAllOrders();

        assertEquals(orderList, result);
        verify(ordersRepository, times(1)).findAll();
    }

    @Test
    void getOrdersByCustomersID() {
        UUID customersID = UUID.randomUUID();
        List<Orders> orderList = new ArrayList<>();
        when(ordersRepository.getOrdersByCustomersId(customersID)).thenReturn(orderList);

        List<Orders> result = ordersService.getOrdersByCustomersID(customersID);

        assertEquals(orderList, result);
        verify(ordersRepository, times(1)).getOrdersByCustomersId(customersID);
    }

    @Test
    void createOrders() {
        Orders order = new Orders();
        when(ordersRepository.save(order)).thenReturn(order);

        Orders result = ordersService.createOrders(order);

        assertEquals(order, result);
        verify(ordersRepository, times(1)).save(order);
    }

    @Test
    void deleteOrders() {
        UUID ordersID = UUID.randomUUID();
        doNothing().when(ordersRepository).deleteById(ordersID);

        assertDoesNotThrow(() -> ordersService.deleteOrders(ordersID));
        verify(ordersRepository, times(1)).deleteById(ordersID);
    }
}
