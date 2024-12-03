package com.solvd.airportmanager.passenger;

public class TicketAlreadySoldException extends RuntimeException {

    public TicketAlreadySoldException(String message) {
        super(message);
    }
}
