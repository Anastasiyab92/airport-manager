package com.solvd.airportmanager.passenger;

import java.time.LocalDate;

public class RegularPassenger extends Passenger {

    private int frequentFlyerPoints;

    public RegularPassenger(String name, String passportNumber, LocalDate dateOfBirth, Gender gender, int frequentFlyerPoints) {
        super(name, passportNumber, dateOfBirth, gender);
        this.frequentFlyerPoints = frequentFlyerPoints;
    }

    public int getFrequentFlyerPoints() {
        return frequentFlyerPoints;
    }

    @Override
    public String passengerType() {
        return "Regular passenger.";
    }
}
