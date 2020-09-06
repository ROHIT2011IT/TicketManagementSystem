package com.rkg.tms.model;

public class Station {
    private int id;
    private int stationNo;
    private String stationName;
    private float distance;

    public Station(int id, int stationNo, String stationName, float distance){
        this.id = id;
        this.stationNo = stationNo;
        this.stationName = stationName;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStationNo() {
        return stationNo;
    }

    public void setStationNo(int stationNo) {
        this.stationNo = stationNo;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
