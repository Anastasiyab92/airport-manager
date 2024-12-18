package com.solvd.airportmanager.flight;

import com.solvd.airportmanager.airport.Gate;
import com.solvd.airportmanager.airport.GateUnavailableException;
import com.solvd.airportmanager.customlambdafunction.CustomFunction;
import com.solvd.airportmanager.passenger.*;
import com.solvd.airportmanager.schedule.Schedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Flight implements Arrivable, Departable {

    private static final Logger LOGGER = LogManager.getLogger(Flight.class);
    private final Gate gate;
    private final String flightNumber;
    private String destination;
    private Schedule arrivalTime;
    private Schedule departureTime;
    private Set<Ticket> tickets = new HashSet<>();
    private Set<Seat> seats = new HashSet<>();
    private Map<Ticket, Baggage> baggageMap = new HashMap<>();
    private List<Passenger> passengers = new ArrayList<>();

    public Flight(String flightNumber, String destination, Schedule arrivalTime, Schedule departureTime, Gate gate) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.gate = gate;
    }

    public static void processArrivals(List<Flight> flights) {
        LOGGER.info("Processing arrivals in Airport:");
        flights.stream()
                .forEach(flight -> {
                    LOGGER.info("Arrival schedule {} at gate {}. ", flight.getArrivalTime(), flight.getArrivalGate());
                    flight.processArrival();
                });
    }

    public static void processDepartures(List<Flight> flights) {
        LOGGER.info("Processing departures from Airport:");
        flights.stream()
                .forEach(flight -> {
                    LOGGER.info("Departure scheduled: {} at gate {}.", flight.getDepartureTime(), flight.getDepartureGate());
                    flight.processDeparture();
                });
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public Gate getGate() {
        return gate;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public Map<Ticket, Baggage> getBaggageMap() {
        return baggageMap;
    }

    @Override
    public LocalDateTime getArrivalTime() {
        return arrivalTime.getDateTime();
    }

    @Override
    public String getArrivalGate() {
        return gate.getGateNumber();
    }

    @Override
    public void processArrival() {
        LOGGER.info("Flight {} has arrived at gate {}. ", flightNumber, getArrivalGate());
    }

    @Override
    public LocalDateTime getDepartureTime() {
        return departureTime.getDateTime();
    }

    @Override
    public String getDepartureGate() {
        return gate.getGateNumber();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger passenger) {
        passengers.add(passenger);
    }

    @Override
    public void processDeparture() {
        LOGGER.info("Flight {} is departing from gate {}.", flightNumber, getDepartureGate());
    }

    public int getPassengerCountOnDate(LocalDate date) {
        if (arrivalTime.getDateTime().toLocalDate().equals(date)) {
            return tickets.size();
        }
        return 0;
    }

    public void sellTicket(Ticket ticket, Baggage baggage) {
        if (tickets.contains(ticket)) {
            throw new TicketAlreadySoldException("Number of ticket: " + ticket.getSeatNumber() + " is already sold!");
        }
        tickets.add(ticket);
        baggageMap.put(ticket, baggage);
    }

    public void bookSeat(Seat seat) {
        if (seat == null) {
            throw new IllegalArgumentException("Seat must not be null.");
        }
        //5.Predicate: to check if a seat is occupied.
        Predicate<Seat> isSeatBooked = s -> seats.contains(s);
        if (isSeatBooked.test(seat)) {
            throw new SeatAlreadyBookedException("Seat: " + seat.getSeatNumber() + " is already booked!");
        }
        seats.add(seat);
    }

    public void assignGate() {
        try (gate) { // AutoCloseable ensures gate is released after use
            gate.reserveGate();
            LOGGER.warn("Gate {} assigned to flight {}.", gate.getGateNumber(), flightNumber);
        } catch (GateUnavailableException e) {
            LOGGER.error("Error assigning gate: ", e);
        } finally { // Always log gate status
            LOGGER.info("Flight {}: gate {} assignment process completed.", flightNumber, gate.getGateNumber());
        }
    }

    public Optional<Passenger> findPassengerByPassportNumber(String passportNumber) {
        return passengers.stream()
                .filter(passenger -> passenger.getPassportNumber().equals(passportNumber))
                .findFirst()
                .or(() -> {
                    throw new PassengerNotFoundException("Passenger with passport " + passportNumber + " not found.");
                });
    }

    public void printInfoPassenger(List<Passenger> passengerList, Consumer<List<Passenger>> consumer) {
        consumer.accept(passengerList);
    }

    public Double countTotalBaggageWeight(Map<Ticket, Baggage> baggageOfFlight, CustomFunction<Map<Ticket, Baggage>, Double> countTotalWeight) {
        return countTotalWeight.apply(baggageOfFlight);
    }

    public Set<Seat> printNumberSeats(Supplier<Set<Seat>> seatSupplier) {
        return seatSupplier.get();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber =' " + flightNumber + '\'' +
                ", destination =' " + destination + '\'' +
                ", arrivalTime = " + arrivalTime.getDateTime() +
                ", departureTime = " + departureTime.getDateTime() +
                ", gate = " + gate +
                ", tickets = " + tickets +
                ", seats = " + seats +
                ", baggageMap = " + baggageMap +
                '}';
    }
}
