package com.solvd.airportmanager.passenger;

import com.solvd.airportmanager.airport.Boardable;

import java.time.LocalDate;
import java.util.Objects;

public class Passenger implements Checkable, Boardable {

    private final String name;
    private final String passportNumber;
    private final LocalDate dateOfBirth;

    public Passenger(String name, String passportNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String passengerType() {
        return "New passenger.";
    }

    @Override
    public boolean verify() throws PassengerNotRegisteredException {
        if (name != null && !name.isEmpty() && passportNumber != null && !passportNumber.isEmpty()
                && dateOfBirth != null) {
            return true;
        } else {
            throw new PassengerNotRegisteredException("Passenger data can't be null or empty.");
        }
    }

    @Override
    public void board() {
        System.out.println(name + " is boarding the plane.");
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(passportNumber, passenger.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportNumber);
    }
}
