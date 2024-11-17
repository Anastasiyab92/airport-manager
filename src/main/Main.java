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
        Passenger passenger3 = new Passenger("Mark", "PM3637384",
                LocalDate.of(1989, 7, 26));
        Passenger passenger4 = new Passenger("Anastasia", "AP9897956",
                LocalDate.of(1977, 12, 31));

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
        ticket2.setPassenger(passenger2);
        AirportUtility.performCheck(ticket1);

        // implementation toString() method. Text representation of the Ticket object.
        System.out.println(ticket1);

        // business method with parameter of ClassType
        System.out.println("Total price of ticket1 " + ticket1.calculateTotalCost(economyClass));
        System.out.println("Total price of ticket2 " + ticket2.calculateTotalCost(economyClass));

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
        ticket3.setPassenger(passenger3);
        ticket4.setPassenger(passenger4);

        // business method with parameter of ClassType
        System.out.println("Total price of ticket3 " + ticket3.calculateTotalCost(businessClass));
        System.out.println("Total price of ticket4 " + ticket4.calculateTotalCost(businessClass));

        ticket3.printTicketDetails();
        ticket4.printTicketDetails();

        Seat seat1 = new Seat("10A");
        Seat seat2 = new Seat("15F");
        Seat seat3 = new Seat("5B");
        Seat seat4 = new Seat("2B");

        Baggage baggage1 = new Baggage(9.8);
        Baggage baggage2 = new Baggage(18.0);

        System.out.println("Excess baggage: " + baggage1.checkOverWeight(EconomyClass.MAX_WEIGHT_BAGGAGE_ECONOMY));
        System.out.println("Excess baggage: " + baggage1.checkOverWeight(BusinessClass.MAX_WEIGHT_BAGGAGE_BUSINESS));

        Gate gate1 = new Gate("G1");
        Gate gate2 = new Gate("G2");

        Schedule arrivalTime1 = new Schedule(LocalDateTime.of(2024, 11, 18, 10, 0));
        Schedule arrivalTime2 = new Schedule(LocalDateTime.of(2024, 11, 18, 8, 0));
        Schedule departureTime1 = new Schedule(LocalDateTime.of(2024, 11, 18, 14, 0));
        Schedule departureTime2 = new Schedule(LocalDateTime.of(2024, 11, 29, 12, 0));

        Flight flight1 = new Flight("A045", "Warsaw", arrivalTime1, departureTime1, gate1);
        Flight flight2 = new Flight("A055", "London", arrivalTime2, departureTime2, gate2);
        Flight flight3 = new Flight("A035", "Amsterdam", arrivalTime1, departureTime1, gate2);
        Flight flight4 = new Flight("A055", "Copenhagen", arrivalTime2, departureTime2, gate1);

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

        Flight[] flights = new Flight[]{flight1, flight2, flight3, flight4};

        // polymorphism business method
        Flight.processArrivals(flights);
        Flight.processDepartures(flights);

        Terminal terminal = new Terminal("Terminal1");
        terminal.setFlights(flights);
        Airline lotPolishAirline = new Airline("LOT Polish Airlines", "Poland");
        lotPolishAirline.setFlights(new Flight[]{flight1, flight2});

        Airline americanAirlines = new Airline("American Airlines", "America");
        americanAirlines.setFlights(new Flight[]{flight3, flight4});

        Airport airport = new Airport("Dubai International Airport", new Terminal[]{terminal});
        airport.setAirlines(new Airline[]{lotPolishAirline, americanAirlines});

        int totalPassengers1 = airport.calculateTotalPassengersOnDate(LocalDate.of(2024, 11, 18));

        System.out.println("Total passengers scheduled for 2024-11-18: " + totalPassengers1);
    }
}