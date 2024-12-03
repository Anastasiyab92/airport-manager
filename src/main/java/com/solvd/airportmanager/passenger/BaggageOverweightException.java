package com.solvd.airportmanager.passenger;

// if the baggage is overweight
public class BaggageOverweightException extends RuntimeException {

    public BaggageOverweightException(String message) {
        super(message);
    }
}
