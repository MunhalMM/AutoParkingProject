package org.telran.autoparking.project.service;

import org.telran.autoparking.project.model.Car;
import org.telran.autoparking.project.model.Parking;

import java.util.List;

public interface ParkingService {

    List<Parking> getAllParking();

    Parking getParking(int id);

    Parking createParking(Parking parking);

    Parking updateParking(Parking parking);

    void removeParking(int id);

    void parkTheCarInParking(int parkingId, int carId);

    void removeCarFromParking(int parkingId, int carId);
}
