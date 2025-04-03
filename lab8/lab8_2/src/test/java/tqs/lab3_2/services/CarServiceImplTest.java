package tqs.lab3_2.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import tqs.lab3_2.entities.Car;
import tqs.lab3_2.repositories.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("BMW", "M3");
        car1.setCarId(1L);
        Car car2 = new Car("Mercedes", "E-Class");
        Car car3 = new Car("Volvo", "V40");
        Car car4 = new Car("BMW", "Serie 1");

        List<Car> allCars = List.of(car1, car2, car3);

        when(carRepository.save(car1)).thenReturn(car1);
        when(carRepository.findAll()).thenReturn(allCars);
        when(carRepository.findCarByCarId(car1.getCarId())).thenReturn(car1);
        when(carRepository.findCarByCarId(-99L)).thenReturn(null);
        when(carRepository.findSuitableReplacements(car1.getCarId(), car1.getMaker())).thenReturn(List.of(car4));
    }

    @Test
    void save() {
        Car car1 = new Car("BMW", "M3");
        assertThat(carService.save(car1)).isEqualTo(car1);
        verify(carRepository, times(1)).save(car1);
    }

    @Test
    void getAllCars() {
        Car car1 = new Car("BMW", "M3");
        Car car2 = new Car("Mercedes", "E-Class");
        Car car3 = new Car("Volvo", "V40");

        List<Car> allCars = carService.getAllCars();
        verify(carRepository, times(1)).findAll();
        assertThat(allCars).hasSize(3).extracting(Car::getModel).containsExactlyInAnyOrder(car1.getModel(), car2.getModel(), car3.getModel());
    }

    @Test
    void getCarDetails() {
        assertThat(carService.getCarDetails(1L).get().getModel()).isEqualTo("M3");
        assertThrows(NullPointerException.class, () -> carService.getCarDetails(-99L));

        verify(carRepository, times(2)).findCarByCarId(Mockito.anyLong());
    }

    @Test
    void findSuitableReplacement() {
        assertThat(carService.findSuitableReplacement(1L).get().getModel()).isEqualTo("Serie 1");
        assertThrows(IllegalArgumentException.class, () -> carService.findSuitableReplacement(-99L));
    }

}