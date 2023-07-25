package com.payetonkawa.payetonkawa.customers;

import com.payetonkawa.payetonkawa.products.ProductsRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Builder
public class CustomersServiceImpl implements ICustomersService{

    private final CustomersRepository customersRepository;

    @Override
   public List<Customers> getAllCustomers(){return customersRepository.findAll();};

    @Override
    public Optional<Customers> getCustomersById(UUID customersId){return customersRepository.findById(customersId);}

    @Override
    public Customers createCustomer(Customers customers){return customersRepository.save(customers);}

    @Override
    public void deleteCustomer(UUID customersId){ customersRepository.deleteById(customersId);};
}
