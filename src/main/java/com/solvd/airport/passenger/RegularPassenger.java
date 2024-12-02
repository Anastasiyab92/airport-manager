package main.java.com.solvd.airport.passenger;

import java.time.LocalDate;

public class RegularPassenger extends Passenger {

    private int frequentFlyerPoints;

    public RegularPassenger(String name, String passportNumber, LocalDate dateOfBirth, int frequentFlyerPoints) {
        super(name, passportNumber, dateOfBirth);
        this.frequentFlyerPoints = frequentFlyerPoints;
    }

    public int getFrequentFlyerPoints() {
        return frequentFlyerPoints;
    }

    @Override
    public String passengerType() {
        return "Regular main.java.com.solvd.airport.passenger.";
    }
}
