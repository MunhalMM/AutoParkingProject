package org.telran.autoparking.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.autoparking.project.model.Car;
import org.telran.autoparking.project.model.Parking;
import org.telran.autoparking.project.repository.ParkingRepository;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private CarService carService;


    @Override
    public List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }

    @Override
    public Parking getParking(int id) {
        return parkingRepository.findById(id).orElse(null);
    }

    @Override
    public Parking createParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    public Parking updateParking(Parking parking) {
        if (parking.getId() == 0) {
            throw new IllegalArgumentException("You entered incorrect ID");
        }
        int id = parking.getId();
        Parking entity = parkingRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setCapacity(entity.getCapacity());
            parkingRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void removeParking(int id) {
        parkingRepository.deleteById(id);
    }


    @Override
    public void parkTheCarInParking(int parkingId, int carId) {
        Car car = carService.getCar(carId);
        Parking parking = parkingRepository.findById(parkingId).orElse(null);

        assert parking != null;
        parking.getCars().add(car);
        parkingRepository.save(parking);
    }

    @Override
    public void removeCarFromParking(int parkingId, int carId) {

        Car car = carService.getCar(carId);
        Parking parking = parkingRepository.findById(parkingId).orElse(null);

        assert parking != null;
        parking.getCars().remove(car);
        parkingRepository.save(parking);

    }
}
