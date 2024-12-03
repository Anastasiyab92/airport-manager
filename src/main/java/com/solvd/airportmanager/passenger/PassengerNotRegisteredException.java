package com.solvd.airportmanager.passenger;

//if the passenger is not registered
public class PassengerNotRegisteredException extends Exception {

    public PassengerNotRegisteredException(String message) {
        super(message);
    }
}
