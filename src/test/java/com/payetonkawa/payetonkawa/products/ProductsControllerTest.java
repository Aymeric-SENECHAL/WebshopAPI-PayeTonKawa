package com.payetonkawa.payetonkawa.products;
import com.payetonkawa.payetonkawa.products.Products;
import com.payetonkawa.payetonkawa.products.ProductsController;
import com.payetonkawa.payetonkawa.products.IProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ProductsControllerTest {
    @Mock
    private IProductsService productsService;

    @InjectMocks
    private ProductsController productsController;
    private ProductsRepository productsRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllProducts() {
        Products product = new Products();
        when(productsService.getAllProducts()).thenReturn(Collections.singletonList(product));

        List<Products> productList = productsController.getAllProducts();

        assertEquals(1, productList.size());
        assertEquals(product, productList.get(0));
        verify(productsService, times(1)).getAllProducts();
    }

    @Test
    void getProductsByID() {
        Products product = new Products();
        UUID productId = UUID.randomUUID();
        when(productsService.getProductsByID(productId)).thenReturn(Optional.of(product));

        Optional<Products> result = productsController.getProductsByID(productId);

        assertTrue(result.isPresent());
        assertEquals(product, result.get());
        verify(productsService, times(1)).getProductsByID(productId);
    }

    @Test
    void getProductsByCustomersIDAndOrdersID() {
        UUID customersID = UUID.randomUUID();
        UUID ordersID = UUID.randomUUID();
        List<Products> expectedProducts = new ArrayList<>();

        // Configure the mock behavior
        when(productsRepository.getProductsByCustomersIDAndOrdersID(customersID, ordersID))
                .thenReturn(expectedProducts);

        List<Products> result = productsService.getProductsByCustomersIDAndOrdersID(customersID, ordersID);

        assertEquals(expectedProducts, result);
        verify(productsRepository, times(1)).getProductsByCustomersIDAndOrdersID(customersID, ordersID);
    }


    @Test
    void createProducts() {
        Products product = new Products();
        when(productsService.createProducts(product)).thenReturn(product);

        Products result = productsController.createProducts(product);

        assertEquals(product, result);
        verify(productsService, times(1)).createProducts(product);
    }
}