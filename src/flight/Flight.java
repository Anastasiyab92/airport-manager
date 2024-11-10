package flight;

import airport.Gate;
import passenger.Baggage;
import passenger.Seat;
import passenger.Ticket;
import schedule.Schedule;

import java.time.LocalDate;

public class Flight {
    private String flightNumber;
    private String destination;
    private Schedule schedule;
    private Gate gate;
    private Ticket[] tickets;
    private Seat[] seats;
    private Baggage[] baggage;

    public Flight(String flightNumber, String destination, Schedule schedule, Gate gate) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.schedule = schedule;
        this.gate = gate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Gate getGate() {
        return gate;
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

    public int getPassengerCountOnDate(LocalDate date) {
        if (schedule.getDateTime().toLocalDate().equals(date)) {
            return tickets.length;
        }
        return 0;
    }
}
