package tqs.lab6_4;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tqs.lab6_4.controllers.CarController;
import tqs.lab6_4.entities.Car;
import tqs.lab6_4.services.CarService;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;


@WebMvcTest(CarController.class)
public class RestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private CarService carService;

    @Test
    void createCar() throws Exception {
        Car newCar = new Car("BMW", "M3");

        when(carService.save(Mockito.any())).thenReturn(newCar);

        RestAssuredMockMvc
                .given().mockMvc(mvc).contentType(MediaType.APPLICATION_JSON).body(JsonUtils.toJson(newCar))
                .when().post("/api/cars")
                .then().assertThat().status(HttpStatus.CREATED).body("model", equalTo("M3"));

        verify(carService, times(1)).save(Mockito.any());
    }

    @Test
    void getAllCars() {
        Car car1 = new Car("BMW", "M3");
        Car car2 = new Car("Mercedes", "Class A");
        List<Car> allCars = List.of(car1, car2);

        when(carService.getAllCars()).thenReturn(allCars);

        RestAssuredMockMvc
                .given().mockMvc(mvc).contentType(MediaType.APPLICATION_JSON)
                .when().get("/api/cars")
                .then()
                    .assertThat()
                    .status(HttpStatus.OK)
                    .body("$.size()", equalTo(2))
                    .body("[0].model", equalTo(car1.getModel()))
                    .body("[1].model", equalTo(car2.getModel()));

        verify(carService, times(1)).getAllCars();
    }

    @Test
    void getCarById() throws Exception {
        Car newCar = new Car(1234L, "BMW", "M3");

        when(carService.getCarDetails(1234L)).thenReturn(Optional.of(newCar));

        RestAssuredMockMvc
                .given().mockMvc(mvc).contentType(MediaType.APPLICATION_JSON)
                .when().get("/api/car/1234")
                .then()
                .assertThat()
                .status(HttpStatus.OK)
                .body("model", equalTo(newCar.getModel()));

        verify(carService, times(1)).getCarDetails(Mockito.any());
    }

}
