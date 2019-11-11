package com.example.graduation_project;

public class Trips {
    public String Region,StratPoint,RallyPoint,Time,EndPoint,PNumber;
    public Trips(){

    }
    public Trips( String Region,String StratPoint,String Time,String RallyPoint ,String EndPoint,String PNumber) {
        this.Region = Region;
        this.StratPoint = StratPoint;
        this.Time = Time;
        this.RallyPoint = RallyPoint;
        this.EndPoint = EndPoint;
        this.PNumber = PNumber;
    }

    @Override
    public String toString() {
        return "Trips{" +
                "Region='" + Region + '\'' +
                ", StratPoint='" + StratPoint + '\'' +
                ", RallyPoint='" + RallyPoint + '\'' +
                ", Time='" + Time + '\'' +
                ", EndPoint='" + EndPoint + '\'' +
                ", PNumber='" + PNumber + '\'' +
                '}';
    }
}
