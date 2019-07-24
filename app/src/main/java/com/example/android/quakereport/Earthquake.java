package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location;
    private long mTimeInMilliseconds;
    private String mDetailURL;

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String detailURL){
        this.magnitude = magnitude;
        this.location = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
        this.mDetailURL = detailURL;
    }


    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getDetailURL() {
        return mDetailURL;
    }
}
