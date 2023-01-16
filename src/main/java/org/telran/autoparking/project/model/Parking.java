package org.telran.autoparking.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parking")
public class Parking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "capacity")
    private int capacity = 100;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_id", referencedColumnName = "id")
    private List<Car> cars = new ArrayList<>();

    public Parking() {
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", cars=" + cars +
                '}';
    }
}
