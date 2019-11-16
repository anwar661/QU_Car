package com.example.graduation_project;

public class Trips {
    public String region;
    public String stratPoint;
    public String rallyPoint;
    public String time;
    public String endPoint;
    public String pNumber;

    public Trips(String region, String stratPoint, String rallyPoint, String time, String endPoint, String pNumber, String trip_id, Cars cars) {
        this.region = region;
        this.stratPoint = stratPoint;
        this.rallyPoint = rallyPoint;
        this.time = time;
        this.endPoint = endPoint;
        this.pNumber = pNumber;
        this.trip_id = trip_id;
        this.cars = cars;
    }

    public String trip_id;
    public  Cars cars;
    public Trips(){

    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStratPoint() {
        return stratPoint;
    }

    public void setStratPoint(String stratPoint) {
        this.stratPoint = stratPoint;
    }

    public String getRallyPoint() {
        return rallyPoint;
    }

    public void setRallyPoint(String rallyPoint) {
        this.rallyPoint = rallyPoint;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }
}
