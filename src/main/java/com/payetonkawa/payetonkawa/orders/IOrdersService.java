package com.payetonkawa.payetonkawa.orders;

import java.util.List;
import java.util.UUID;

public interface IOrdersService {

    List<Orders> getAllOrders();

    List<Orders> getOrdersByCustomersID(UUID customersID);

    Orders createOrders(Orders orders);

    void deleteOrders(UUID ordersID);
}
