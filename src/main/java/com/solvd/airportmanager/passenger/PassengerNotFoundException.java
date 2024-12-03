package com.solvd.airportmanager.passenger;

// passenger registration error
public class PassengerNotFoundException extends RuntimeException {

    public PassengerNotFoundException(String message) {
        super(message);
    }
}
