package tqs.lab3_2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tqs.lab3_2.entities.Car;
import tqs.lab3_2.repositories.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarDetails(Long carId) {
        return Optional.of(carRepository.findCarByCarId(carId));
    }

    @Override
    public Optional<Car> findSuitableReplacement(Long carId) {
        Car car = carRepository.findCarByCarId(carId);
        if (car == null) {
            throw new IllegalArgumentException();
        }

        return carRepository.findSuitableReplacements(car.getCarId(), car.getMaker()).stream().findFirst();
    }

}
