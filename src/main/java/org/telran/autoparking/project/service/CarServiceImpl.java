package org.telran.autoparking.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.telran.autoparking.project.model.Car;
import org.telran.autoparking.project.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(int id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car) {
        if (car.getId() == 0) {
            throw new IllegalArgumentException("You entered incorrect ID");
        }
        int id = car.getId();
        Car entity = carRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setName(entity.getName());
            entity.setColor(entity.getColor());
            entity.setYearOfProduction(entity.getYearOfProduction());
            carRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void remove(int id) {
        carRepository.deleteById(id);
    }
}
