package flight;

import airport.Gate;
import airport.GateUnavailableException;
import passenger.*;
import schedule.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Flight implements Arrivable, Departable {

    private String flightNumber;
    private String destination;
    private Schedule arrivalTime;
    private Schedule departureTime;
    private final Gate gate;
    private Set<Ticket> tickets = new HashSet<>();
    private Set<Seat> seats = new HashSet<>();
    private Map<Ticket, Baggage> baggageMap = new HashMap<>();

    public Flight(String flightNumber, String destination, Schedule arrivalTime, Schedule departureTime, Gate gate) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.gate = gate;
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
        System.out.println("Flight " + flightNumber + " has arrived at gate " + getArrivalGate() + ".");
    }

    @Override
    public LocalDateTime getDepartureTime() {
        return departureTime.getDateTime();
    }

    @Override
    public String getDepartureGate() {
        return gate.getGateNumber();
    }

    @Override
    public void processDeparture() {
        System.out.println("Flight " + flightNumber + " is departing from gate " + getDepartureGate() + ".");
    }

    public static void processArrivals(List<Flight> flights) {
        System.out.println("Processing arrivals in Airport:");
        for (Arrivable flight : flights) {
            System.out.println("Arrival schedule " + flight.getArrivalTime() + " at gate " + flight.getArrivalGate());
            flight.processArrival();
        }
    }

    public static void processDepartures(List<Flight> flights) {
        System.out.println("Processing departures from Airport:");
        for (Departable flight : flights) {
            System.out.println("Departure scheduled: " + flight.getDepartureTime() + "at gate " + flight.getDepartureGate());
            flight.processDeparture();
        }
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
        if (seats.contains(seat)) {
            throw new SeatAlreadyBookedException("Seat: " + seat.getSeatNumber() + " is already booked!");
        }
        seats.add(seat);
    }

    public void assignGate() {
        try (gate) { // AutoCloseable ensures gate is released after use
            gate.reserveGate();
            System.out.println("Gate " + gate.getGateNumber() + " assigned to flight " + flightNumber + ".");
        } catch (GateUnavailableException e) {
            System.out.println("Error assigning gate: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber =' " + flightNumber + '\'' +
                ", destination =' " + destination + '\'' +
                ", arrivalTime = " + arrivalTime.dateTime +
                ", departureTime = " + departureTime.dateTime +
                ", gate = " + gate +
                ", tickets = " + tickets +
                ", seats = " + seats +
                ", baggageMap = " + baggageMap +
                '}';
    }
}
