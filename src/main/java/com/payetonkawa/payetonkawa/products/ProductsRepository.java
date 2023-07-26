package com.payetonkawa.payetonkawa.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {

    @Query(value = "SELECT * " +
            "FROM orders_products " +
            "JOIN products on products.id = orders_products.products_id " +
            "JOIN orders on orders.id = orders_products.order_id " +
            "WHERE orders.customers_id = ?1 " +
            "WHERE orders_products.products_id = ?2 ", nativeQuery = true)
    List<Products> getProductsByCustomersIDAndOrdersID(UUID customersID, UUID ordersID);

}
