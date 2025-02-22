package tqs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductFinderServiceTest {

    private final String PRODUCTS_API = "https://fakestoreapi.com/products/";

    @Mock
    ISimpleHttpClient httpClient;

    @InjectMocks
    ProductFinderService productFinder;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        httpClient = null;
        productFinder = null;
    }

    @Test
    void findProductDetails() {
        when(httpClient.doHttpGet(PRODUCTS_API + 3)).thenReturn("{" +
                "\"id\":3," +
                "\"title\":\"Mens Cotton Jacket\"" +
                "}");

        Optional<Product> product = productFinder.findProductDetails(3);
        Product expected = new Product();
        expected.setId(3);
        expected.setTitle("Mens Cotton Jacket");
        assertEquals(Optional.of(expected), product);
    }

    @Test
    void findNotFoundProduct() {
        when(httpClient.doHttpGet(PRODUCTS_API + 300)).thenReturn("Error found in id.");

        Optional<Product> product = productFinder.findProductDetails(300);
        assertTrue(product.isEmpty());
    }

}