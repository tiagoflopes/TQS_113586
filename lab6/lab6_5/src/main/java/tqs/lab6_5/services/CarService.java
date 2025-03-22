package tqs.lab6_5.services;

import tqs.lab6_5.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car save(Car car);
    List<Car> getAllCars();
    Optional<Car> getCarDetails(Long carId);
    Optional<Car> findSuitableReplacement(Long carId);

}
