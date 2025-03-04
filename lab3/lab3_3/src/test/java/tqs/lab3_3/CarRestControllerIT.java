package tqs.lab3_3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import tqs.lab3_3.entities.Car;
import tqs.lab3_3.repositories.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class CarRestControllerIT {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository carRepository;

    @AfterEach
    public void resetDb() {
        carRepository.deleteAll();
    }

    @Test
    void testCreateCar() {
        Car car1 = new Car("BMW", "X5");
        restTemplate.postForEntity("/api/cars", car1, Car.class);

        List<Car> found = carRepository.findAll();
        assertThat(found).extracting(Car::getMaker).containsOnly("BMW");
    }

    @Test
    void testCreateAndFindCar() {
        createCar("BMW", "X5");
        createCar("Mercedes", "E-Class");

        ResponseEntity<List<Car>> response = restTemplate.exchange(
            "/api/cars",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Car>>() {
        });

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Car::getMaker).containsExactly("BMW", "Mercedes");
    }

    private void createCar(String maker, String model) {
        carRepository.saveAndFlush(new Car(maker, model));
    }

}
