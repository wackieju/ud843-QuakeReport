package com.example.android.quakereport;

public class Earthquake {
    private float magnitude;
    private String location;
    private String date;

    public Earthquake(float magnitude, String location, String date){
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }


    public float getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
