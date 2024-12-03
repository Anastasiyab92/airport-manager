package com.solvd.airportmanager.airport;

import com.solvd.airportmanager.flight.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Terminal implements Notifiable {

    protected String name;
    private List<Flight> flights = new ArrayList<>();

    public Terminal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public void notification(String message) {
        System.out.println("Terminal: " + name + ", notification: " + message);
    }

    public int calculateCountPassengersOnDate(LocalDate date) {
        int countPassengers = 0;
        for (Flight flight : flights) {
            countPassengers += flight.getPassengerCountOnDate(date);
        }
        return countPassengers;
    }
}
