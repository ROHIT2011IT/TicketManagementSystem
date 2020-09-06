package com.rkg.tms.controller;

import com.rkg.tms.model.TMSModel;
import com.rkg.tms.model.Ticket;
import com.rkg.tms.view.TMSView;

import java.util.Scanner;

public class TMSController {
    private static final TMSModel tmsModel = new TMSModel();
    private static final Scanner scanner = new Scanner(System.in);
    private static final TMSView tmsView = new TMSView();

    public void getMenu(){
        int choice = 0;
        do{
            int fromStationId = 0;
            int toStationId = 0;
            int age = 0;
            int returnJourney = 0;
            System.out.println("Please enter 1 For ticket");
            System.out.println("Please Enter 2 For Exit");
            System.out.println("Please enter your choice");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    printStations();
                    System.out.println("Please Select your fromStationID");
                    fromStationId = scanner.nextInt();
                    System.out.println("Please Select your toStationID");
                    toStationId = scanner.nextInt();
                    System.out.println("Enter passenger age");
                    age = scanner.nextInt();
                    System.out.println("Please enter 1 for return ticket otherwise enter any numeric no");
                    returnJourney = scanner.nextInt();
                    boolean isReturnJourney = returnJourney == 1 ? true : false;
                    Ticket ticket = tmsModel.getTicket(fromStationId, toStationId, age, isReturnJourney);
                    tmsView.printTicket(ticket);
                    break;
                case 2:
                    System.exit(0);
            }
        }while(choice > 0 && choice < 3);
    }

    private void printStations(){
        System.out.println("StationID  StationName");
        tmsModel.getStations().forEach(x->{
            System.out.println(x.getStationNo()+"       "+x.getStationName());
        });
    }
}
