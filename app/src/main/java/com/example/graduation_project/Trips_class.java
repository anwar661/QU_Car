package com.example.graduation_project;

public class Trips_class {

    public String name;
    public String car;
    public String trip_id;

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String driver_id;
    public Trips_class() {
    }
    public String getName() {
        return name;
    }

    public String getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(String car) {
        this.car = car;
    }

}
