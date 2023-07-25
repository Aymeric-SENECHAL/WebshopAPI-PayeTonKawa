package com.payetonkawa.payetonkawa.orders;

import com.payetonkawa.payetonkawa.products.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {

    List<Orders> findAllByCustomers_Id(UUID customersId);

}
