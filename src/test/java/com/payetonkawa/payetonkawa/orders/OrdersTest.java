package com.payetonkawa.payetonkawa.orders;

import com.payetonkawa.payetonkawa.customers.Customers;
import com.payetonkawa.payetonkawa.products.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class OrdersTest {
    private Orders order;
    private Customers customers;
    private List<Products> productsList;

    @BeforeEach
    void setUp() {
        order = new Orders();
    }

    @Test
    void testGetterAndSetterForCustomers() {
        Customers customers = mock(Customers.class);
        order.setCustomers(customers);
        assertEquals(customers, order.getCustomers());
    }

    @Test
    void testGetterAndSetterForProductsList() {
        List<Products> productsList = new ArrayList<>();
        productsList.add(mock(Products.class));
        productsList.add(mock(Products.class));
        order.setProductsList(productsList);
        assertEquals(productsList, order.getProductsList());
    }

    @Test
    void testToString() {
        Customers customers = Customers.builder()
                .name("John Doe")
                .email(null)
                .build();

        Products product1 = Products.builder()
                .name("Product 1")
                .description(null)
                .color(null)
                .stock(null)
                .ordersList(null)
                .build();

        Products product2 = Products.builder()
                .name("Product 2")
                .description(null)
                .color(null)
                .stock(null)
                .ordersList(null)
                .build();

        order.setCustomers(customers);
        order.setProductsList(Arrays.asList(product1, product2));

        String expectedToString = "Orders(customers=Customers(name=John Doe, username=null, firstname=null, lastname=null, postalCode=null, adressCity=null, profileFirstname=null, profileLastname=null, companyName=null, email=null, token=null, ordersList=null), productsList=[Products(price=null, name=Product 1, description=null, color=null, stock=null, ordersList=null), Products(price=null, name=Product 2, description=null, color=null, stock=null, ordersList=null)])";
        assertEquals(expectedToString, order.toString());
    }

    @Test
    void testNoArgsConstructor() {
        assertNotNull(order);
    }

    @Test
    void testAllArgsConstructor() {
        Customers customers = mock(Customers.class);
        List<Products> productsList = new ArrayList<>();
        productsList.add(mock(Products.class));

        Orders orderWithArgs = new Orders(customers, productsList);

        assertEquals(customers, orderWithArgs.getCustomers());
        assertEquals(productsList, orderWithArgs.getProductsList());
    }

    @Test
    void builder() {
        Orders builtOrder = Orders.builder()
                .customers(customers)
                .productsList(productsList)
                .build();

        assertEquals(customers, builtOrder.getCustomers());
        assertEquals(productsList, builtOrder.getProductsList());
    }
}
