package com.payetonkawa.payetonkawa.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomersTest {

    private Customers customers;

    @BeforeEach
    void setUp() {
        customers = new Customers();
    }

    @Test
    void testGetName() {
        customers.setName("Logan Quillet");

        assertEquals("Logan Quillet", customers.getName());
    }

    @Test
    void testGetUsername() {
        customers.setUsername("loganquillet");
        assertEquals("loganquillet", customers.getUsername());
    }



    @Test
    void testToString() {
        customers.setName("Logan Quillet");
        customers.setUsername("loganquillet");
        customers.setFirstname("Logan");
        customers.setLastname("Quillet");
        customers.setPostalCode("000");
        customers.setAdressCity("Arras");
        customers.setProfileFirstname("logan");
        customers.setProfileLastname("quillet");
        customers.setCompanyName("epsi");
        customers.setEmail("logan@gmail.com");
        customers.setToken("0");
        String expectedToString = "Customers(name=Logan Quillet, username=loganquillet, firstname=Logan, lastname=Quillet, postalCode=000, adressCity=Arras, profileFirstname=logan, profileLastname=quillet, companyName=epsi, email=logan@gmail.com, token=0, ordersList=null)";
        assertEquals(expectedToString, customers.toString());
    }


    @Test
    void testBuilder() {
        Customers builtCustomers = Customers.builder()
                .name("Logan Quillet")
                .username("loganquillet")
                .build();

        assertEquals("Logan Quillet", builtCustomers.getName());
        assertEquals("loganquillet", builtCustomers.getUsername());
    }
}