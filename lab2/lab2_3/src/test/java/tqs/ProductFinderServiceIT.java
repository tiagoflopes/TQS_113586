package tqs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductFinderServiceIT {

    private ProductFinderService productFinder;

    @BeforeEach
    void setUp() {
        ISimpleHttpClient httpClient = new SimpleHttpClient();
        productFinder = new ProductFinderService(httpClient);
    }

    @AfterEach
    void tearDown() {
        productFinder = null;
    }

    @Test
    void findProductDetails() throws IOException {
        Optional<Product> product = productFinder.findProductDetails(3);
        Product expected = new Product();
        expected.setId(3);
        expected.setTitle("Mens Cotton Jacket");
        expected.setPrice(55.99);
        expected.setDescription("great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.");
        expected.setCategory("men's clothing");
        expected.setImage("https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg");
        assertEquals(Optional.of(expected), product);
    }

    @Test
    void findNotFoundProduct() throws IOException {
        Optional<Product> product = productFinder.findProductDetails(300);
        assertTrue(product.isEmpty());
    }

}