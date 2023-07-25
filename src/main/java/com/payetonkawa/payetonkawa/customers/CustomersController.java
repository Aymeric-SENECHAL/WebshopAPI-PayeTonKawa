package com.payetonkawa.payetonkawa.customers;

import com.payetonkawa.payetonkawa.products.Products;
import lombok.Builder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin()
@RestController
@Builder
@RequestMapping("/api/v1/")
public class CustomersController {

    private ICustomersService customersService;

    @GetMapping("/customers")
    public List<Customers> getAllProducts(){
        return customersService.getAllCustomers();
    }

    @GetMapping("/customers/{customersId}")
    public Optional<Customers> getCustomersById(@PathVariable UUID customersId){
        return customersService.getCustomersById(customersId);
    }

    @PostMapping("/customers")
    public Customers createCustomer(@RequestBody Customers customers){
        return customersService.createCustomer(customers);
    }

    @DeleteMapping("/customers/{customersId}")
    public void deleteCustomer(@PathVariable UUID customersId){
        customersService.deleteCustomer(customersId);
    }
}
