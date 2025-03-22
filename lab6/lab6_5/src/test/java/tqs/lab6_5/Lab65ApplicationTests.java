package tqs.lab6_5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import tqs.lab6_5.entities.Car;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Lab65ApplicationTests {

    @LocalServerPort
    private Integer port;

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

    @BeforeEach
    void setUp() {
        baseURI = "http://localhost:" + port;
    }

    @Test
    @Order(1)
    void testCreateCar() throws Exception {
        Car newCar = new Car("BMW", "X5");

        given()
                .contentType(ContentType.JSON)
                .body(JsonUtils.toJson(newCar))
        .when()
                .post("/api/cars")
        .then()
                .assertThat()
                .statusCode(201)
                .body("model", equalTo("X5"));
    }

    @Test
    @Order(2)
    void testCreateAndFindCar() throws Exception {
        Car newCar = new Car("Mercedes", "E-Class");

        given()
                .contentType(ContentType.JSON)
                .body(JsonUtils.toJson(newCar))
        .when()
                .post("/api/cars")
        .then()
                .assertThat()
                .statusCode(201);

        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/api/cars")
        .then()
                .assertThat()
                .statusCode(200)
                .body("$.size()", equalTo(2))
                .body("[0].model", equalTo("X5"))
                .body("[1].model", equalTo("E-Class"))
                .body("maker", hasItems("BMW", "Mercedes"));
    }

}
