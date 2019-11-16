package com.example.graduation_project;

public class Cars {
    public String carTyps,carCollor,carPlate;
    public Cars(){

    }

    @Override
    public String toString() {
        return "Cars{" +
                "carTyps='" + carTyps + '\'' +
                ", carCollor='" + carCollor + '\'' +
                ", carPlate='" + carPlate + '\'' +
                '}';
    }

    public Cars(String carTyps, String carCollor, String carPlate) {
        this.carTyps = carTyps;
        this.carCollor = carCollor;
        this.carPlate = carPlate;
    }

    public String getCarTyps() {
        return carTyps;
    }

    public void setCarTyps(String carTyps) {
        this.carTyps = carTyps;
    }

    public String getCarCollor() {
        return carCollor;
    }

    public void setCarCollor(String carCollor) {
        this.carCollor = carCollor;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
}
