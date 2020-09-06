package com.rkg.tms.model;

import java.time.Instant;

public class Ticket {
    private Instant purchaseTime;
    private String fromStation;
    private String toStation;
    private int noOfStops;
    private double fare;
    private boolean isReturnTicket;
    private double distance;

    public Ticket(Instant purchaseTime, String fromStation, String toStation, int noOfStops, double fare, boolean isReturnTicket, double distance) {
        this.purchaseTime = purchaseTime;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.noOfStops = noOfStops;
        this.fare = fare;
        this.isReturnTicket = isReturnTicket;
        this.distance = distance;
    }

    public Instant getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Instant purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public int getNoOfStops() {
        return noOfStops;
    }

    public void setNoOfStops(int noOfStops) {
        this.noOfStops = noOfStops;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public boolean isReturnTicket() {
        return isReturnTicket;
    }

    public void setReturnTicket(boolean returnTicket) {
        isReturnTicket = returnTicket;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
