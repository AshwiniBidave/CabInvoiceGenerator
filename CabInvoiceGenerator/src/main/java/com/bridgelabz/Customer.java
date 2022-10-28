package com.bridgelabz;

public class Customer {
	private Ride[] rides;
    private int id;

    public Customer(int id, Ride[] rides) {
        this.id = id;
        this.rides = rides;
    }

    public Ride[] getRides() {
        return rides;
    }

    public void setRides(Ride[] rides) {
        this.rides = rides;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
