package com.payetonkawa.payetonkawa.orders;

import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Builder
public class OrdersServiceImpl implements IOrdersService {

    private final OrdersRepository ordersRepository;

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public List<Orders> getOrdersByCustomersID(UUID customersID) {
        return ordersRepository.getOrdersByCustomersId(customersID);
    }


    @Override
    public Orders createOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void deleteOrders(UUID ordersID) {
        ordersRepository.deleteById(ordersID);
    }
}
