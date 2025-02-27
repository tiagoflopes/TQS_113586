package tqs.lab3_2.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import tqs.lab3_2.services.CarService;


import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mvc;


    private CarService carService;

    @Test
    void createCar() {
    }

    @Test
    void getAllCars() {
    }

    @Test
    void getCarById() {
    }
}