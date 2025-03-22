package tqs;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestTest {

    @Test
    @Order(1)
    void testTodoEndpoint() {
        given()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos")
        .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Order(2)
    void testTodo4Title() {
        given()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/4")
        .then()
                .assertThat()
                .body("title", equalTo("et porro tempora"));
    }

    @Test
    @Order(3)
    void testTodoIds() {
        given()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos")
        .then()
                .assertThat()
                .body("id", hasItems(198, 199));
    }

    @Test
    @Order(4)
    void testTodoResponseTime() {
        given()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos")
        .then()
                .assertThat()
                .time(lessThan(2L), TimeUnit.SECONDS);
    }

}
