package com.payetonkawa.payetonkawa.products;

import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Builder
public class ProductsServiceImpl implements IProductsService {
    private final ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Optional<Products> getProductsByID(UUID productsID) {
        return productsRepository.findById(productsID);
    }

    @Override
    public List<Products> getProductsByCustomersIDAndOrdersID(UUID customersID, UUID ordersID) {
        return new ArrayList<>();
    }

    @Override
    public Products createProducts(Products products) {
        return productsRepository.save(products);
    }

    public void deleteProductsByID(UUID productsID) {
        productsRepository.deleteById(productsID);
    }

}

