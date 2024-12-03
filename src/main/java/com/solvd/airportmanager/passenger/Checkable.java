package com.solvd.airportmanager.passenger;

public interface Checkable {

    boolean verify() throws PassengerNotRegisteredException;
}
