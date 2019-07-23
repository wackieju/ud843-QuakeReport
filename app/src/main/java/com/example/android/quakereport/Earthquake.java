package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location;
    private String date;

    public Earthquake(double magnitude, String location, String date){
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }


    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
