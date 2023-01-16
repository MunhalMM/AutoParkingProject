package org.telran.autoparking.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.autoparking.project.model.Car;
import org.telran.autoparking.project.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    //localhost:8080/cars
    @GetMapping
    public List<Car> list() {
        return carService.getAllCars();
    }

    //localhost:8080/cars/{id}
    @GetMapping("/{id}")
    public Car getCar(@PathVariable(name = "id") int id) {
        return carService.getCar(id);
    }

    //localhost:8080/cars
    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void removeCar(@PathVariable(name = "id") int id) {
        carService.remove(id);
    }
}
