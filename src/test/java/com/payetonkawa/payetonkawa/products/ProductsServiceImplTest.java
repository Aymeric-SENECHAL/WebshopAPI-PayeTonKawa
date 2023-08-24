package com.payetonkawa.payetonkawa.products;
import com.payetonkawa.payetonkawa.products.Products;
import com.payetonkawa.payetonkawa.products.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductsServiceImplTest {

    @Mock
    private ProductsRepository productsRepository;

    @InjectMocks
    private ProductsServiceImpl productsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllProducts() {
        List<Products> productList = new ArrayList<>();
        when(productsRepository.findAll()).thenReturn(productList);

        List<Products> result = productsService.getAllProducts();

        assertEquals(productList, result);
        verify(productsRepository, times(1)).findAll();
    }

    @Test
    void getProductsByID() {
        UUID productId = UUID.randomUUID();
        Products product = new Products();
        when(productsRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<Products> result = productsService.getProductsByID(productId);

        assertTrue(result.isPresent());
        assertEquals(product, result.get());
        verify(productsRepository, times(1)).findById(productId);
    }

    @Test
    void getProductsByCustomersIDAndOrdersID() {
        // Simulate this method's behavior with mocks
    }

    @Test
    void createProducts() {
        Products product = new Products();
        when(productsRepository.save(product)).thenReturn(product);

        Products result = productsService.createProducts(product);

        assertEquals(product, result);
        verify(productsRepository, times(1)).save(product);
    }

    @Test
    void deleteProductsByID() {
        UUID productId = UUID.randomUUID();
        doNothing().when(productsRepository).deleteById(productId);

        assertDoesNotThrow(() -> productsService.deleteProductsByID(productId));
        verify(productsRepository, times(1)).deleteById(productId);
    }
}