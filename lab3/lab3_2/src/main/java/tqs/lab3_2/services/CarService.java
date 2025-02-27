package tqs.lab3_2.services;

import tqs.lab3_2.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car save(Car car);
    List<Car> getAllCars();
    Optional<Car> getCarDetails(Long carId);

}
