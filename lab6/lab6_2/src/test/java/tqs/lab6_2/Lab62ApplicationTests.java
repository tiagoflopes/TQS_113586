package tqs.lab6_2;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import tqs.lab6_2.entities.Customer;
import tqs.lab6_2.repositories.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Import(TestcontainersConfiguration.class)
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class Lab62ApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Container
    static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>()
            .withUsername("user")
            .withPassword("password")
            .withDatabaseName("test");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.jpa.database-platform", () -> "org.hibernate.dialect.PostgreSQLDialect");
        registry.add("spring.jpa.show-sql", () -> "true");
    }

    @Test
    @Order(1)
    void isDatabaseEmpty() {
        assertTrue(customerRepository.findAll().isEmpty());
    }

    @Test
    @Order(2)
    void insertCustomer() {
        Customer c = new Customer(1, "Tiago", 20, "Viseu");
        customerRepository.save(c);
        assertEquals(1, customerRepository.count());
    }

    @Test
    @Order(3)
    void retrieveCustomer() {
        Customer c = customerRepository.getCustomerById(1);
        assertEquals("Tiago", c.getName());
        assertEquals(20, c.getAge());
        assertEquals("Viseu", c.getAddress());
    }

    @Test
    @Order(4)
    void deleteCustomer() {
        customerRepository.deleteById(1);
        assertEquals(0, customerRepository.count());
    }

    @Test
    @Order(5)
    void countThem() {
        System.out.println(customerRepository.count());
    }

}
