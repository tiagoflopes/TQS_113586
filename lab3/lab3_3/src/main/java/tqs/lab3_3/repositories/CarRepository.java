package tqs.lab3_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tqs.lab3_3.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarByCarId(Long carId);

    @Query("SELECT c FROM Car c WHERE c.maker = :maker AND c.carId != :carId")
    List<Car> findSuitableReplacements(@Param("carId") Long carId, @Param("maker") String maker);

}
