package org.telran.autoparking.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.autoparking.project.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
