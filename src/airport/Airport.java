package airport;

import flight.Airline;

import java.time.LocalDate;

public class Airport {
    private String name;
    private Airline[] airlines;
    private Terminal[] terminals;

    public Airport(String name, Airline[] airlines, Terminal[] terminals) {
        this.name = name;
        this.airlines = airlines;
        this.terminals = terminals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setTerminals(Terminal[] terminals) {
        this.terminals = terminals;
    }

    public int calculateTotalPassengersOnDate(LocalDate date){
        int totalPassengers = 0;
        for(Terminal terminal : terminals){
            totalPassengers += terminal.calculateCountPassengersOnDate(date);
        }
        return totalPassengers;
    }
}
