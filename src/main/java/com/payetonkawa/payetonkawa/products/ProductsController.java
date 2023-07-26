package com.payetonkawa.payetonkawa.products;


import lombok.Builder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin()
@RestController
@Builder
@RequestMapping("/api/v1/")
public class ProductsController {
    private IProductsService productsService;

    @GetMapping("/products")
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/products/{productsID}")
    public Optional<Products> getProductsByID(@PathVariable UUID productsID) {
        return productsService.getProductsByID(productsID);
    }

    @GetMapping("/customers/{customersID}/orders/{ordersID}/products")
    public List<Products> getProductsByCustomersIDAndOrdersID(@PathVariable UUID customersID, @PathVariable UUID ordersID) {
        return productsService.getProductsByCustomersIDAndOrdersID(customersID, ordersID);
    }

    @PostMapping("/products")
    public Products createProducts(@RequestBody Products products) {
        return productsService.createProducts(products);
    }

    @DeleteMapping("/products/{productsID}")
    public void deleteProductsByID(@PathVariable UUID productsID) {
        productsService.deleteProductsByID(productsID);
    }
}
