package com.rkg.tms.view;

import com.rkg.tms.model.Ticket;

public class TMSView {

    public void printTicket(Ticket ticket){
        System.out.println("purchase Time: "+ticket.getPurchaseTime());
        System.out.println("From Station: "+ticket.getFromStation());
        System.out.println("To Station: "+ticket.getToStation());
        System.out.println("No of Stops: "+ticket.getNoOfStops());
        System.out.println("Total fare: "+ticket.getFare());
        System.out.println("Total Disctance: "+ticket.getDistance());
        if(ticket.isReturnTicket()){
            System.out.println("Return Ticket");
        }
    }
}
