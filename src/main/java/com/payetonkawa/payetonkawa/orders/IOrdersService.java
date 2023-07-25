package com.payetonkawa.payetonkawa.orders;


import com.payetonkawa.payetonkawa.products.Products;

import java.util.List;
import java.util.UUID;

public interface IOrdersService {
    List<Orders> getAllOrdersByCustomer(UUID customerId);
}
