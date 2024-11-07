package main;

import airport.Airport;
import airport.Gate;
import airport.Terminal;
import flight.Airline;
import flight.Flight;
import passenger.Baggage;
import passenger.Passenger;
import passenger.Seat;
import passenger.Ticket;
import schedule.Schedule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Sergei", "PM1234567",
                LocalDate.of(1990, 5, 15));
        Passenger passenger2 = new Passenger("Anton", "PM7654321",
                LocalDate.of(1999, 6, 10));

        Ticket ticket1 = new Ticket("A351", "Economy", new BigDecimal(123));
        ticket1.setPassenger(passenger1);
        Ticket ticket2 = new Ticket("B500", "Business", new BigDecimal(550));
        ticket2.setPassenger(passenger2);

        Seat seat1 = new Seat("10A");
        Seat seat2 = new Seat("5B");

        Baggage baggage1 = new Baggage(15.8);
        Baggage baggage2 = new Baggage(20.0);

        Gate gate1 = new Gate("G1");
        Gate gate2 = new Gate("G2");

        Schedule schedule1 = new Schedule(LocalDateTime.of(2024,11,18,10,0));
        Schedule schedule2 = new Schedule(LocalDateTime.of(2024,11,18,8,0));

        Flight flight1 = new Flight("A045", "Warsaw", schedule1, gate1);
        Flight flight2 = new Flight("A055", "London", schedule2, gate2);

        flight1.setTickets(new Ticket[]{ ticket1 });
        flight1.setSeats(new Seat[]{ seat1 });
        flight1.setBaggage(new Baggage[]{ baggage1 });
        flight2.setTickets(new Ticket[]{ ticket2 });
        flight2.setSeats(new Seat[]{ seat2 });
        flight2.setBaggage(new Baggage[]{ baggage2 });

        Terminal terminal = new Terminal("Terminal1");
        terminal.setFlights(new Flight[]{ flight1, flight2 });

        Airline airline = new Airline("Emirates");
        airline.setFlights(new Flight[]{ flight1, flight2 });

        Airport airport = new Airport("Dubai International Airport", new Terminal[]{ terminal });
        airport.setAirlines(new Airline[]{ airline });

        int totalPassengers = airport.calculateTotalPassengersOnDate(LocalDate.of(2024,11,18));
        System.out.println("Total passengers scheduled for 2024-11-18: " + totalPassengers);
    }
}