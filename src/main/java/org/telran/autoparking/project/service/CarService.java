package org.telran.autoparking.project.service;

import org.telran.autoparking.project.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    Car getCar(int id);

    Car save(Car car);

    Car updateCar(Car car);

    void remove(int id);
}
