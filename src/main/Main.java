package main;

import airport.Airport;
import airport.Gate;
import airport.Terminal;
import classtype.BusinessClass;
import classtype.ClassType;
import classtype.EconomyClass;
import flight.*;
import passenger.Baggage;
import passenger.Passenger;
import passenger.Seat;
import passenger.Ticket;
import schedule.Schedule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Sergei", "PM1234567",
                LocalDate.of(1990, 5, 15));
        Passenger passenger2 = new Passenger("Anton", "PM7654321",
                LocalDate.of(1999, 6, 10));

        // implementation toString() method. Text representation of the Passenger object.
        System.out.println(passenger1);
        System.out.println(passenger2);

        //implementation equals() ahd hashCode() methods for comparison two objects the passportNumber field of Passenger.
        System.out.println("The same passenger: " + passenger1.equals(passenger2));
        System.out.println("Hash of passenger1: " + passenger1.hashCode());
        System.out.println("Hash of passenger2: " + passenger2.hashCode());
        System.out.print("The same hash of two passengers: ");
        System.out.println(passenger1.hashCode() == passenger2.hashCode());

        ClassType economyClass = new EconomyClass();
        ClassType businessClass = new BusinessClass();

        //implementation toString() method. Text representation of the ClassType object.
        System.out.println(Arrays.toString(economyClass.getServices()));
        System.out.println(Arrays.toString(businessClass.getServices()));

        //implementation equals() ahd hashCode() methods for comparison two objects the name field of ClassType.
        System.out.println("The same the type of class: " + economyClass.equals(businessClass));
        System.out.println("Hash of economyClass : " + economyClass.hashCode());
        System.out.println("Hash of businessClass: " + businessClass.hashCode());
        System.out.print("The same hash of two classTypes: ");
        System.out.println(economyClass.hashCode() == businessClass.hashCode());

        Ticket ticket1 = new Ticket("A351", new BigDecimal(123), economyClass);
        Ticket ticket2 = new Ticket("A153", new BigDecimal(150), economyClass);
        ticket1.setPassenger(passenger1);
        ticket2.setPassenger(passenger1);

        //// implementation toString() method. Text representation of the Ticket object.
        System.out.println(ticket1);
        System.out.println(ticket2);

        //implementation equals() ahd hashCode() methods for comparison two objects at all fields of Ticket .
        System.out.println("The same ticket: " + ticket1.equals(ticket2));
        System.out.println("Hash of ticket1: " + ticket1.hashCode());
        System.out.println("Hash of ticket2: " + ticket2.hashCode());
        System.out.print("The same hash of two tickets: ");
        System.out.println(ticket1.hashCode() == ticket2.hashCode());

        ticket1.printTicketDetails();
        ticket2.printTicketDetails();

        Ticket ticket3 = new Ticket("B500", new BigDecimal(550), businessClass);
        Ticket ticket4 = new Ticket("B005", new BigDecimal(450), businessClass);
        ticket3.setPassenger(passenger2);
        ticket4.setPassenger(passenger2);
        ticket3.printTicketDetails();

        Seat seat1 = new Seat("10A");
        Seat seat2 = new Seat("15F");
        Seat seat3 = new Seat("5B");
        Seat seat4 = new Seat("2B");


        Baggage baggage1 = new Baggage(9.8);
        Baggage baggage2 = new Baggage(18.0);

        Gate gate1 = new Gate("G1");
        Gate gate2 = new Gate("G2");

        Schedule schedule1 = new Schedule(LocalDateTime.of(2024, 11, 18, 10, 0));
        Schedule schedule2 = new Schedule(LocalDateTime.of(2024, 11, 18, 8, 0));
        Schedule schedule3 = new Schedule(LocalDateTime.of(2024, 11, 29, 10, 0));
        Schedule schedule4 = new Schedule(LocalDateTime.of(2024, 11, 29, 8, 0));

        Flight flight1 = new Flight("A045", "Warsaw", schedule1, gate1);
        Flight flight2 = new Flight("A055", "London", schedule2, gate2);
        Flight flight3 = new Flight("A035", "Amsterdam", schedule3, gate2);
        Flight flight4 = new Flight("A055", "Copenhagen", schedule4, gate1);

        flight1.setTickets(new Ticket[]{ticket1});
        flight1.setSeats(new Seat[]{seat1});
        flight1.setBaggage(new Baggage[]{baggage1});
        flight2.setTickets(new Ticket[]{ticket2});
        flight2.setSeats(new Seat[]{seat2});
        flight2.setBaggage(new Baggage[]{baggage2});
        flight3.setTickets(new Ticket[]{ticket3});
        flight3.setSeats(new Seat[]{seat3});
        flight3.setBaggage(new Baggage[]{baggage2});
        flight4.setTickets(new Ticket[]{ticket4});
        flight4.setSeats(new Seat[]{seat4});
        flight4.setBaggage(new Baggage[]{baggage1});

        Terminal terminal = new Terminal("Terminal1");
        terminal.setFlights(new Flight[]{flight1, flight2, flight3, flight4});

        Airline americanAirlines = new AmericanAirlines();
        americanAirlines.setFlights(new Flight[]{flight2, flight4});

        Airline lotPolishAirlines = new LotPolishAirlines();
        lotPolishAirlines.setFlights(new Flight[]{flight1, flight3});

        Airport airport = new Airport("Dubai International Airport", new Terminal[]{terminal});
        airport.setAirlines(new Airline[]{americanAirlines, lotPolishAirlines});

        //call business method with parameter Airline
        AirlineService airlineService = new AirlineService();

        for (Airline line : airport.getAirlines()) {
            airlineService.printServiceInfo(line);
        }

        int totalPassengers1 = airport.calculateTotalPassengersOnDate(LocalDate.of(2024, 11, 18));
        int totalPassengers2 = airport.calculateTotalPassengersOnDate(LocalDate.of(2024, 11, 29));

        System.out.println("Total passengers scheduled for 2024-11-18: " + totalPassengers1);
        System.out.println("Total passengers scheduled for 2024-11-29: " + totalPassengers2);
    }
}