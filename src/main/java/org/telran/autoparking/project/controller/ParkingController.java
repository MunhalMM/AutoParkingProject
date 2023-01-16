package org.telran.autoparking.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.autoparking.project.model.Parking;
import org.telran.autoparking.project.service.ParkingService;

import java.util.List;

@RestController
@RequestMapping("parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping
    public List<Parking> listParking() {
        return parkingService.getAllParking();
    }

    @GetMapping("/{id}")
    public Parking getParking(@PathVariable(name = "id") int id) {
        return parkingService.getParking(id);
    }

    @PostMapping
    public Parking createParking(@RequestBody Parking parking) {
        return parkingService.createParking(parking);
    }

    @PutMapping
    public Parking updateParking(@RequestBody Parking parking) {
        return parkingService.updateParking(parking);
    }

    @DeleteMapping("/{id}")
    public void removeParking(@PathVariable(name = "id") int id) {
        parkingService.removeParking(id);
    }

    @PostMapping("/{parkingId}/{carId}")
    public void parkTheCarInParking(@PathVariable(name = "parkingId") int parkingId, @PathVariable(name = "carId") int carId) {
        parkingService.parkTheCarInParking(parkingId, carId);
    }

    @DeleteMapping("/{parkingId}/{carId}")
    public void removeCarFromParking(@PathVariable(name = "parkingId") int parkingId, @PathVariable(name = "carId") int carId) {
        parkingService.removeCarFromParking(parkingId, carId);
    }
}
