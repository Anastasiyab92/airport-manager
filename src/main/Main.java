package main;

import airport.Airport;
import airport.Gate;
import airport.Terminal;
import classtype.BusinessClass;
import classtype.ClassType;
import classtype.EconomyClass;
import flight.*;
import passenger.*;
import schedule.Schedule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Sergei", "PM1234567",
                LocalDate.of(1990, 5, 15));
        Passenger passenger2 = new Passenger("Anton", "PM7654321",
                LocalDate.of(1999, 6, 10));
        Passenger passenger3 = new Passenger("Mark", "PM3637384",
                LocalDate.of(1989, 7, 26));
        Passenger passenger4 = new Passenger("Anastasia", "AP9897956",
                LocalDate.of(1977, 12, 31));

        Passenger passenger5 = new Passenger("", "PK1234567",
                LocalDate.of(1978, 2, 14));

        try {
            passenger1.verify();
            passenger5.verify();
        } catch (PassengerNotRegisteredException ex) {
            System.out.println("Error in passenger data: " + ex.getMessage());
        }

        // implementation toString() method. Text representation of the Passenger object.
        System.out.println(passenger1);

        //implementation equals() ahd hashCode() methods for comparison two objects the passportNumber field of Passenger.
        System.out.println("The same passenger: " + passenger1.equals(passenger2));
        System.out.println("Hash of passenger1: " + passenger1.hashCode());
        System.out.println("Hash of passenger2: " + passenger2.hashCode());
        System.out.print("The same hash of two passengers: ");
        System.out.println(passenger1.hashCode() == passenger2.hashCode());

        ClassType economyClass = new EconomyClass();
        ClassType businessClass = new BusinessClass();

        //implementation toString() method. Text representation of the ClassType object.
        System.out.println(economyClass.getServices());
        System.out.println(businessClass.getServices());

        //implementation equals() ahd hashCode() methods for comparison two objects the name field of ClassType.
        System.out.println("The same the type of class: " + economyClass.equals(businessClass));
        System.out.println("Hash of economyClass : " + economyClass.hashCode());
        System.out.println("Hash of businessClass: " + businessClass.hashCode());
        System.out.print("The same hash of two classTypes: ");
        System.out.println(economyClass.hashCode() == businessClass.hashCode());

        Baggage baggage1 = new Baggage(9.8, economyClass);
        Baggage baggage2 = new Baggage(8.8, economyClass);
        Baggage baggage3 = new Baggage(18.8, businessClass);
        Baggage baggage4 = new Baggage(19.8, businessClass);

        Ticket ticket1 = new Ticket("A351", new BigDecimal(123), economyClass);
        Ticket ticket2 = new Ticket("A153", new BigDecimal(150), economyClass);
        Ticket ticket3 = new Ticket("B500", new BigDecimal(550), businessClass);
        Ticket ticket4 = new Ticket("B005", new BigDecimal(450), businessClass);

        ticket1.setPassenger(passenger1);
        ticket2.setPassenger(passenger2);
        ticket3.setPassenger(passenger3);
        ticket4.setPassenger(passenger4);

        try {
            AirportUtility.performCheck(ticket1);
        } catch (Exception e) {
            System.out.println("Check the passenger's data: " + e.getMessage());
        }

        // implementation toString() method. Text representation of the Ticket object.
        System.out.println(ticket1);

        // business method with parameter of ClassType
        System.out.println("Total price of ticket1 " + ticket1.calculateTotalCost(economyClass));
        System.out.println("Total price of ticket2 " + ticket2.calculateTotalCost(economyClass));
        System.out.println("Total price of ticket3 " + ticket3.calculateTotalCost(businessClass));
        System.out.println("Total price of ticket4 " + ticket4.calculateTotalCost(businessClass));

        //implementation equals() ahd hashCode() methods for comparison two objects at all fields of Ticket .
        System.out.println("The same ticket: " + ticket1.equals(ticket2));
        System.out.println("Hash of ticket1: " + ticket1.hashCode());
        System.out.println("Hash of ticket2: " + ticket2.hashCode());
        System.out.print("The same hash of two tickets: ");
        System.out.println(ticket1.hashCode() == ticket2.hashCode());

        ticket1.printTicketDetails();
        ticket2.printTicketDetails();
        ticket3.printTicketDetails();
        ticket4.printTicketDetails();

        Seat seat1 = new Seat("10A");
        Seat seat2 = new Seat("15F");
        Seat seat3 = new Seat("5B");
        Seat seat4 = new Seat("2B");

        Gate gate1 = new Gate("G1");
        Gate gate2 = new Gate("G2");

        Schedule arrivalTime1 = new Schedule(LocalDateTime.of(2024, 11, 18, 10, 0));
        Schedule arrivalTime2 = new Schedule(LocalDateTime.of(2024, 11, 18, 8, 0));
        Schedule departureTime1 = new Schedule(LocalDateTime.of(2024, 11, 18, 14, 0));
        Schedule departureTime2 = new Schedule(LocalDateTime.of(2024, 11, 29, 12, 0));

        Flight flight1 = new Flight("A045", "Warsaw", arrivalTime1, departureTime1, gate1);
        Flight flight2 = new Flight("A055", "London", arrivalTime2, departureTime2, gate2);

        try {
            flight1.sellTicket(ticket1, baggage1);
            flight1.sellTicket(ticket3, baggage3);
            flight2.sellTicket(ticket2, baggage2);
            flight2.sellTicket(ticket4, baggage4);
            flight1.sellTicket(ticket1, baggage1);//Will throw exception
        } catch (TicketAlreadySoldException e) {
            System.out.println("Error selling ticket: " + e.getMessage());
        }

        try {
            flight1.bookSeat(seat1);
            flight2.bookSeat(seat2);
            flight1.bookSeat(seat3);
            flight2.bookSeat(seat4);
            flight2.bookSeat(seat4);
        } catch (SeatAlreadyBookedException e) {
            System.out.println("Error booking seat: " + e.getMessage());
        }

        flight1.assignGate();
        flight2.assignGate();

        // try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Information of flight: " + flight1);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);

        // polymorphism business method
        Flight.processArrivals(flights);
        Flight.processDepartures(flights);

        for (Ticket ticket : flight1.getTickets()) {
            System.out.println("Type of class: " + ticket.getClassType().getName() + "; seat number: " + ticket.getSeatNumber()
                    + "; passenger: " + ticket.getPassenger().getName());
        }

        for (Seat seat : flight1.getSeats()) {
            System.out.println("Numbers of seats: " + seat.getSeatNumber());
        }

        for (Map.Entry<Ticket, Baggage> entity : flight1.getBaggageMap().entrySet()) {
            System.out.println("Ticket: " + entity.getKey() + ". " + entity.getValue());
        }

        Terminal terminal = new Terminal("Terminal1");
        terminal.setFlights(flights);
        Airline lotPolishAirline = new Airline("LOT Polish Airlines", "Poland");
        lotPolishAirline.addFlight(flight1);

        Airline americanAirlines = new Airline("American Airlines", "America");
        americanAirlines.addFlight(flight2);

        Airport airport = new Airport("Dubai International Airport", new ArrayList<>(Arrays.asList(terminal)));
        airport.addAirline(lotPolishAirline);
        airport.addAirline(americanAirlines);

        int totalPassengers1 = airport.calculateTotalPassengersOnDate(LocalDate.of(2024, 11, 18));

        System.out.println("Total passengers scheduled for 2024-11-18: " + totalPassengers1);
    }
}