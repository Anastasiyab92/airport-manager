package com.solvd.airportmanager.airport;

import com.solvd.airportmanager.flight.Airline;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    private static final Logger LOGGER = LogManager.getLogger(Airport.class);
    protected String name;
    private List<Airline> airlines = new ArrayList<>();
    private List<Terminal> terminals;

    // execute this block for initialisation of data before create an instance of Airport
    static {
        LOGGER.info("Airport initialized.");
    }

    public Airport(String name, List<Terminal> terminals) {
        this.name = name;
        this.terminals = terminals;
    }

    public String getName() {
        return name;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void addAirline(Airline airline) {
        airlines.add(airline);
    }

    public int calculateTotalPassengersOnDate(LocalDate date) {
        int totalPassengers = 0;
        for (Terminal terminal : terminals) {
            totalPassengers += terminal.calculateCountPassengersOnDate(date);
        }
        return totalPassengers;
    }
}
