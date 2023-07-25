package com.payetonkawa.payetonkawa.orders;

import com.payetonkawa.payetonkawa.customers.Customers;
import com.payetonkawa.payetonkawa.customers.CustomersRepository;
import com.payetonkawa.payetonkawa.products.Products;
import com.payetonkawa.payetonkawa.products.ProductsRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Builder
public class OrdersServiceImpl implements IOrdersService{

    private final OrdersRepository ordersRepository;

    @Override
    public List<Orders> getAllOrdersByCustomer(UUID customerId){
        return ordersRepository.findAllByCustomers_Id(customerId);
    }

}
