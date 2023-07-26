package com.payetonkawa.payetonkawa.customers;

import lombok.Builder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin()
@RestController
@Builder
@RequestMapping("/api/v1/")
public class CustomersController {

    private ICustomersService customersService;

    @GetMapping("/customers")
    public List<Customers> getAllCustomers() {
        return customersService.getAllCustomers();
    }

    @PostMapping("/customers")
    public Customers createCustomers(@RequestBody Customers customers) {
        return customersService.createCustomer(customers);
    }

    @DeleteMapping("/customers/{customersId}")
    public void deleteCustomer(@PathVariable UUID customersId) {
        customersService.deleteCustomer(customersId);
    }

}
