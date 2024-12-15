package com.solvd.airportmanager.airport;

import com.solvd.airportmanager.flight.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Terminal implements Notifiable {

    private static final Logger LOGGER = LogManager.getLogger(Terminal.class);
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
        LOGGER.info("Terminal: {}, notification: {}. ", name, message);
    }

    public void printInfoFlight(List<Flight> flightlist, Function<Flight, String> printInfo) {
        flightlist.stream()
                .map(printInfo)
                .forEach(LOGGER::info);
    }

    public void executeTask(Runnable task) {
        task.run();
    }

    public int calculateCountPassengersOnDate(LocalDate date) {
        return flights.stream()
                .mapToInt(flight -> flight.getPassengerCountOnDate(date))
                .sum();
    }
}
