package airport;

import flight.Airline;

import java.time.LocalDate;

public class Airport {

    protected String name;
    private Airline[] airlines;
    private Terminal[] terminals;

    public Airport(String name, Terminal[] terminals) {
        this.name = name;
        this.terminals = terminals;
    }

    public String getName() {
        return name;
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    public void setAirlines(Airline[] airlines) {
        this.airlines = airlines;
    }

    public Terminal[] getTerminals() {
        return terminals;
    }

    public int calculateTotalPassengersOnDate(LocalDate date) {
        int totalPassengers = 0;
        for (Terminal terminal : terminals) {
            totalPassengers += terminal.calculateCountPassengersOnDate(date);
        }
        return totalPassengers;
    }
}
