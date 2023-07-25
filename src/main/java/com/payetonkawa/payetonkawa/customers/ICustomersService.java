package com.payetonkawa.payetonkawa.customers;

import com.payetonkawa.payetonkawa.products.Products;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICustomersService {

    List<Customers> getAllCustomers();

    Optional<Customers> getCustomersById(UUID customersId);

    Customers createCustomer(Customers customers);

    void deleteCustomer(UUID customersId);
}
