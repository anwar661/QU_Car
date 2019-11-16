package com.example.graduation_project;

public class Trips {
    public String region,stratPoint,rallyPoint,time,endPoint,pNumber;
    public  Cars cars;
    public Trips(){

    }

    public Trips(String region, String stratPoint, String rallyPoint, String time, String endPoint, String pNumber, Cars cars) {
        this.region = region;
        this.stratPoint = stratPoint;
        this.rallyPoint = rallyPoint;
        this.time = time;
        this.endPoint = endPoint;
        this.pNumber = pNumber;
        this.cars = cars;
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
