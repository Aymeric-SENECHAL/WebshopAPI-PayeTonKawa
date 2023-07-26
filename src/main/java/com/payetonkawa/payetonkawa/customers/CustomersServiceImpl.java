package com.payetonkawa.payetonkawa.customers;

import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Builder
public class CustomersServiceImpl implements ICustomersService {

    private final CustomersRepository customersRepository;

    @Override
    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Customers createCustomer(Customers customers) {
        return customersRepository.save(customers);
    }

    @Override
    public void deleteCustomer(UUID customersId) {
        customersRepository.deleteById(customersId);
    }

    ;
}
