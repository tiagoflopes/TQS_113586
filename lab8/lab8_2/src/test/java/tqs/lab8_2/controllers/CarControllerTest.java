package tqs.lab8_2.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tqs.lab8_2.entities.Car;
import tqs.lab8_2.services.CarService;
import tqs.lab8_2.JsonUtils;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private CarService carService;

    @Test
    void createCar() throws Exception {
        Car newCar = new Car("BMW", "M3");

        when(carService.save(Mockito.any())).thenReturn(newCar);

        mvc.perform(
                post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(newCar)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.model", is("M3")));

        verify(carService, times(1)).save(Mockito.any());
    }

    @Test
    void getAllCars() throws Exception {
        Car car1 = new Car("BMW", "M3");
        Car car2 = new Car("Mercedes", "Class A");
        List<Car> allCars = List.of(car1, car2);

        when(carService.getAllCars()).thenReturn(allCars);

        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].model", is(car1.getModel())))
                .andExpect(jsonPath("$[1].model", is(car2.getModel())));

        verify(carService, times(1)).getAllCars();
    }

    @Test
    void getCarById() throws Exception {
        Car newCar = new Car(1234L, "BMW", "M3");

        when(carService.getCarDetails(1234L)).thenReturn(Optional.of(newCar));

        mvc.perform(get("/api/car/1234").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model", is("M3")));

        verify(carService, times(1)).getCarDetails(Mockito.any());
    }

}