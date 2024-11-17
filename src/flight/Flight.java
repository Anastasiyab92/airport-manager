package flight;

import airport.Gate;
import passenger.Baggage;
import passenger.Seat;
import passenger.Ticket;
import schedule.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight implements Arrivable, Departable {

    private String flightNumber;
    private String destination;
    private Schedule arrivalTime;
    private Schedule departureTime;
    private Gate gate;
    private Ticket[] tickets;
    private Seat[] seats;
    private Baggage[] baggage;

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

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public Baggage[] getBaggage() {
        return baggage;
    }

    public void setBaggage(Baggage[] baggage) {
        this.baggage = baggage;
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

    public static void processArrivals(Arrivable[] flights) {
        System.out.println("Processing arrivals in Airport:");
        for (Arrivable flight : flights) {
            System.out.println("Arrival schedule " + flight.getArrivalTime() + " at gate " + flight.getArrivalGate());
            flight.processArrival();
        }
    }

    public static void processDepartures(Departable[] flights) {
        System.out.println("Processing departures from Airport:");
        for (Departable flight : flights) {
            System.out.println("Departure scheduled: " + flight.getDepartureTime() + "at gate " + flight.getDepartureGate());
            flight.processDeparture();
        }
    }

    public int getPassengerCountOnDate(LocalDate date) {
        if (arrivalTime.getDateTime().toLocalDate().equals(date)) {
            return tickets.length;
        }
        return 0;
    }
}
