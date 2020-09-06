package com.rkg.tms.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TMSModel {
    private List<Station> stations = new ArrayList<>();

    //TODO should be in constant
    private static final int BASE_STATIONS_LIMIT = 5;
    private static final int BASE_FARE = 10;
    private static final int UP_EXTRA_STATION_LIMIT = 5;
    private static final int EXTRA_BATCH_FARE = 5;
    private static final int COMPLETE_JOURNEY_FARE = 20;
    private static final int AGE_FOR_NO_FARE = 3;
    private static final int AGE_FOR_DISCOUNTED_FARE = 10;
    private static final double DISCOUNTED_PERCENT = 0.75;

    public TMSModel(){
        stations = populateStations();
    }


    private List<Station> populateStations(){
        List<Station> stations = Arrays.asList(
                new Station(1, 1, "Chennai Beach", 0),
                new Station(2, 2, "Chennai Fort", 10),
                new Station(3, 3, "Chennai Park", 10),
                new Station(4, 4, "Chennai Egmore", 10),
                new Station(5, 5, "Chetpet", 10),
                new Station(6, 6, "Nungambakkam", 10),
                new Station(7, 7, "Kodambakkam", 10),
                new Station(8, 8, "Mambalam", 10),
                new Station(9, 9, "Saidapet", 10),
                new Station(10,10, "Guindy", 10),
                new Station(11,11, "St. Thomas Mount", 10),
                new Station(12,12, "Pazhavanthangal", 10),
                new Station(13,13, "Meenambakkam", 10),
                new Station(14,14, "Trisulam", 10),
                new Station(15,15, "Pallavaram", 10),
                new Station(16,16, "Chromepet", 10),
                new Station(17,17, "Tambaram Sanatorium", 10),
                new Station(18,18, "Tambaram", 10));
        return stations;
    }

    public List<Station> getStations(){
        return stations;
    }

    private int getFare(int fromStationNo, int toStationNo, int noOfStation){
        if(isCompleteJourney(fromStationNo, toStationNo)){
            return COMPLETE_JOURNEY_FARE;
        }
        else{
            return getFareBetweenTwoStation(fromStationNo, toStationNo, noOfStation);
        }
    }

    private boolean isCompleteJourney(int fromStationNo, int toStationNo){
        int firstStationNo = stations.get(0).getStationNo();
        int lastStationNo = stations.get(stations.size()-1).getStationNo();
        boolean isFromIsFirstStation = fromStationNo == firstStationNo || fromStationNo == lastStationNo;
        boolean isToIsLastStation = toStationNo == firstStationNo || toStationNo == lastStationNo;
        return isFromIsFirstStation && isToIsLastStation;
    }

    public Ticket getTicket(int fromStationNo, int toStationNo, int age, boolean isReturnTicket){
        int noOfStations = Math.abs(fromStationNo-toStationNo);
        double fare = 0;
        if(age >= AGE_FOR_NO_FARE){
            fare = getFare(fromStationNo, toStationNo, noOfStations);
        }
        if(age < AGE_FOR_DISCOUNTED_FARE){
            fare = fare * DISCOUNTED_PERCENT;
        }
        if(isReturnTicket){
            fare = fare * 1.75;
        }
        double distanceBetweenStations = getDistance(fromStationNo, toStationNo);
        String fromStationName = stations.get(fromStationNo-1).getStationName();
        String toStationName = stations.get(toStationNo-1).getStationName();
        Ticket ticket = new Ticket(Instant.now(), fromStationName, toStationName, noOfStations,fare,isReturnTicket, distanceBetweenStations);
        return ticket;
    }

    private double getDistance (int fromStationNo, int toStationNo){
        double distance = 0;
        boolean isFromEnd = stations.get(fromStationNo-1).getStationNo() > stations.get(toStationNo-1).getStationNo();
        if(isFromEnd) {
            int temp = fromStationNo;
            fromStationNo = toStationNo;
            toStationNo = temp;
        }
        for(int start = fromStationNo; start <= toStationNo-1 ; start++){
            distance = distance + stations.get(start).getDistance();
        }
        return distance;
    }

    private int getFareBetweenTwoStation(int fromStationNo, int toStationNo, int noOfStation){
        int fare = BASE_FARE;
        int extraStations = noOfStation - BASE_STATIONS_LIMIT;
        if(extraStations > 0){
            int noOfExtraStationBatch = extraStations / UP_EXTRA_STATION_LIMIT;
            boolean isPartialBatch = extraStations % UP_EXTRA_STATION_LIMIT > 0 ? true : false;
            noOfExtraStationBatch = isPartialBatch ? noOfExtraStationBatch+1 : noOfExtraStationBatch;
            fare = fare + noOfExtraStationBatch * EXTRA_BATCH_FARE;
        }
        return fare;
    }
}
