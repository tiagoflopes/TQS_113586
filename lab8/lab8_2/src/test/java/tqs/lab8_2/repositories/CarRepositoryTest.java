package tqs.lab8_2.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import tqs.lab8_2.entities.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    void findCarByCarId() {
        Car car = new Car("BMW", "M3");
        entityManager.persistAndFlush(car);

        Car fromDb = carRepository.findCarByCarId(car.getCarId());
        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getModel()).isEqualTo(car.getModel());
    }

    @Test
    void invalidFindCarByCarId() {
        Car fromDb = carRepository.findCarByCarId(-111L);
        assertThat(fromDb).isNull();
    }

    @Test
    void findSuitableReplacements() {
        Car car1 = new Car("BMW", "M3");
        Car car2 = new Car("BMW", "Serie 1");
        entityManager.persistAndFlush(car1);
        entityManager.persistAndFlush(car2);

        assertThat(carRepository.findSuitableReplacements(car1.getCarId(), car1.getMaker())).hasSize(1).isEqualTo(List.of(car2));
    }
}