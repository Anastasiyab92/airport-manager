package com.solvd.airportmanager.passenger;

import java.time.LocalDate;

public class VipPassenger extends Passenger {
    private boolean loungeAccess;

    public VipPassenger(String name, String passportNumber, LocalDate dateOfBirth, Gender gender, boolean loungeAccess) {
        super(name, passportNumber, dateOfBirth, gender);
        this.loungeAccess = loungeAccess;

    }

    public boolean isLoungeAccess() {
        return loungeAccess;
    }

    @Override
    public String passengerType() {
        return "VIP passenger.";
    }
}
