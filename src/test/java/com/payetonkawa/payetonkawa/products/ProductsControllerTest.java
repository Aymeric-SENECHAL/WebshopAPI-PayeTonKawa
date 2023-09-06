package com.payetonkawa.payetonkawa.products;
import com.payetonkawa.payetonkawa.products.Products;
import com.payetonkawa.payetonkawa.products.ProductsController;
import com.payetonkawa.payetonkawa.products.IProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        productsController = new ProductsController(productsService);
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

        // Créer une liste de produits simulée que vous attendez de retourner
        List<Products> expectedProducts = new ArrayList<>();
        // Ajoutez des produits simulés à la liste expectedProducts ici

        // Configurez le comportement du service pour renvoyer expectedProducts lorsque la méthode est appelée
        when(productsService.getProductsByCustomersIDAndOrdersID(customersID, ordersID))
                .thenReturn(expectedProducts);

        // Appelez la méthode du contrôleur que vous testez
        List<Products> result = productsController.getProductsByCustomersIDAndOrdersID(customersID, ordersID);

        // Vérifiez si le résultat est égal à expectedProducts
        assertEquals(expectedProducts, result);
    }


    @Test
    void createProducts() {
        Products product = new Products();
        when(productsService.createProducts(product)).thenReturn(product);

        Products result = productsController.createProducts(product);

        assertEquals(product, result);
        verify(productsService, times(1)).createProducts(product);
    }

    @Test
    void deleteProductsByID() {
        UUID productsID = UUID.randomUUID();

        // Appelez la méthode du contrôleur que vous testez
        productsController.deleteProductsByID(productsID);

        // Vérifiez que la méthode du service correspondante a été appelée une fois avec l'ID approprié
        verify(productsService, times(1)).deleteProductsByID(productsID);
    }
}