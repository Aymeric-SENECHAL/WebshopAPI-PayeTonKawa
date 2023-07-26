package com.payetonkawa.payetonkawa.orders;

import lombok.Builder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin()
@RestController
@Builder
@RequestMapping("/api/v1/")
public class OrdersController {

    private IOrdersService ordersService;

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/customers/{customersID}/orders")
    public List<Orders> getOrdersByCustomersID(@PathVariable UUID customersID) {
        return ordersService.getOrdersByCustomersID(customersID);
    }

    @PostMapping("/orders")
    public Orders createOrders(@RequestBody Orders orders) {
        return ordersService.createOrders(orders);
    }

    @DeleteMapping("/orders/{ordersId}")
    public void deleteOrders(@PathVariable UUID ordersId) {
        ordersService.deleteOrders(ordersId);
    }
}
