package com.payetonkawa.payetonkawa.orders;

import com.payetonkawa.payetonkawa.customers.Customers;
import lombok.Builder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin()
@RestController
@Builder
@RequestMapping("/api/v1/customers")
public class OrdersController {

    private IOrdersService ordersService;

    @GetMapping("{customerId}/orders")
    public List<Orders> getAllOrdersByCustomer(@PathVariable UUID customerId) {
        return ordersService.getAllOrdersByCustomer(customerId);
    }

    @PostMapping("{customerId}/orders")
    public  Orders createOrder(@PathVariable UUID customerId, @RequestBody Orders orders){
        return ordersService.createOrder(customerId, orders);
    }

}
