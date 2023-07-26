package com.payetonkawa.payetonkawa.customers;

import java.util.List;
import java.util.UUID;

public interface ICustomersService {

    List<Customers> getAllCustomers();

    Customers createCustomer(Customers customers);

    void deleteCustomer(UUID customersId);
}
