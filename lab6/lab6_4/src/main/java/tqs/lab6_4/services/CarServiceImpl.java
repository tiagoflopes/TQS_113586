package tqs.lab6_4.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tqs.lab6_4.entities.Car;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    @Override
    public Car save(Car car) {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public Optional<Car> getCarDetails(Long carId) {
        return Optional.empty();
    }

    @Override
    public Optional<Car> findSuitableReplacement(Long carId) {
        return Optional.empty();
    }

}
