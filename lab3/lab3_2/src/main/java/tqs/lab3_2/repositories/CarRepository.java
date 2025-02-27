package tqs.lab3_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tqs.lab3_2.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarByCarId(Long carId);
    List<Car> findAll();

}
