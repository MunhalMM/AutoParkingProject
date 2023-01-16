package org.telran.autoparking.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.autoparking.project.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
}
