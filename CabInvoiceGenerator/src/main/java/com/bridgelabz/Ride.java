package com.bridgelabz;
enum RideType{
    NORMAL,
    PREMIUM
}

public class Ride {
	private RideType rideType;
    private double distance;
    private double time;

    public Ride(double distance, double time ) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(double distance, double time, RideType rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public RideType getRideType() {
        return rideType;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }
}
