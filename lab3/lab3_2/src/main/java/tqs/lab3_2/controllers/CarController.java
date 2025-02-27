package tqs.lab3_2.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.lab3_2.entities.Car;
import tqs.lab3_2.services.CarService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/car")
    public ResponseEntity<Car> getCarById(@RequestParam Long carId) {
        Optional<Car> car = carService.getCarDetails(carId);
        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car.get());
    }

}
