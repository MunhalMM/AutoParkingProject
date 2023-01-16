package org.telran.autoparking.project.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_production")
    private int yearOfProduction;
    @Column(name = "color")
    private String color;

    public Car() {
        //
    }

    public Car(int id, String name, int yearOfProduction, String color) {
        this.id = id;
        this.name = name;
        this.yearOfProduction = yearOfProduction;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", color='" + color + '\'' +
                '}';
    }
}
