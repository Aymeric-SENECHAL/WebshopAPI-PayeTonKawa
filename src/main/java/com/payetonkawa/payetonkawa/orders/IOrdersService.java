package com.payetonkawa.payetonkawa.orders;


import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IOrdersService {
    List<Orders> getAllOrdersByCustomer(UUID customerId);

    Orders createOrder(UUID customerId, Orders orders);
}
