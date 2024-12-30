package com.solvd.airportmanager;

import com.solvd.airportmanager.airport.*;
import com.solvd.airportmanager.classtype.BusinessClass;
import com.solvd.airportmanager.classtype.ClassType;
import com.solvd.airportmanager.classtype.EconomyClass;
import com.solvd.airportmanager.customlambdafunction.CustomFunction;
import com.solvd.airportmanager.flight.Airline;
import com.solvd.airportmanager.flight.Flight;
import com.solvd.airportmanager.flight.FlightType;
import com.solvd.airportmanager.passenger.*;
import com.solvd.airportmanager.schedule.Schedule;
import com.solvd.airportmanager.schedule.WeekDay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Sergei", "PM1234567",
                LocalDate.of(1990, 5, 15), Gender.MALE);
        Passenger passenger2 = new Passenger("Julia", "PM7654321",
                LocalDate.of(1999, 6, 10), Gender.FEMALE);
        Passenger passenger3 = new Passenger("Mark", "PM3637384",
                LocalDate.of(1989, 7, 26), Gender.MALE);
        Passenger passenger4 = new Passenger("Anastasia", "AP9897956",
                LocalDate.of(1977, 12, 31), Gender.FEMALE);

        Passenger passenger5 = new Passenger("", "PK1234567",
                LocalDate.of(1978, 2, 14), null);

        try {
            passenger1.verify();
            passenger2.verify();
            passenger5.verify();
        } catch (PassengerNotRegisteredException ex) {
            LOGGER.error("Error in passenger data: ", ex);
        }

        //implementation toString() method. Text representation of the Passenger object.
        LOGGER.debug(passenger1);

        //implementation equals() ahd hashCode() methods for comparison two objects the passportNumber field of Passenger.
        LOGGER.debug("The same passenger: {}\nHash of passenger1: {}\nHash of passenger2: {}",
                passenger1.equals(passenger2), passenger1.hashCode(), passenger2.hashCode());
        LOGGER.info("The same hash of two passengers: ");
        LOGGER.debug(passenger1.hashCode() == passenger2.hashCode());

        ClassType economyClass = new EconomyClass();
        ClassType businessClass = new BusinessClass();

        //implementation toString() method. Text representation of the ClassType object.
        LOGGER.debug(economyClass.getServices());
        LOGGER.debug(businessClass.getServices());

        //implementation equals() ahd hashCode() methods for comparison two objects the name field of ClassType.
        LOGGER.debug("The same the type of class: {}\nHash of economyClass : {}\nHash of businessClass: {}",
                economyClass.equals(businessClass), economyClass.hashCode(), businessClass.hashCode());
        LOGGER.info("The same hash of two classTypes: ");
        LOGGER.debug(economyClass.hashCode() == businessClass.hashCode());

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
            LOGGER.error("Check the passenger's data: ", e);
        }

        //implementation toString() method. Text representation of the Ticket object.
        LOGGER.debug(ticket1);

        // business method with parameter of ClassType
        LOGGER.warn("Total price of ticket1 {}", ticket1.calculateTotalCost(economyClass));
        LOGGER.warn("Total price of ticket2 {}", ticket2.calculateTotalCost(economyClass));
        LOGGER.warn("Total price of ticket3 {}", ticket3.calculateTotalCost(businessClass));
        LOGGER.warn("Total price of ticket4 {}", ticket4.calculateTotalCost(businessClass));

        //implementation equals() ahd hashCode() methods for comparison two objects at all fields of Ticket .
        LOGGER.debug("The same ticket: {}\nHash of ticket1: {}\nHash of ticket2: {}",
                ticket1.equals(ticket2), ticket1.hashCode(), ticket2.hashCode());
        LOGGER.info("The same hash of two tickets: ");
        LOGGER.warn(ticket1.hashCode() == ticket2.hashCode());

        Seat seat1 = new Seat("10A");
        Seat seat2 = new Seat("15F");
        Seat seat3 = new Seat("5B");
        Seat seat4 = new Seat("2B");

        Gate gate1 = new Gate("G1");
        Gate gate2 = new Gate("G2");

        //Simple enum GateType
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Available Gate Types: {}", Arrays.toString(GateType.values()));
        }

        Schedule arrivalTime1 = new Schedule(LocalDateTime.of(2024, 11, 18, 10, 0));
        Schedule arrivalTime2 = new Schedule(LocalDateTime.of(2024, 11, 18, 8, 0));
        Schedule departureTime1 = new Schedule(LocalDateTime.of(2024, 11, 18, 14, 0));
        Schedule departureTime2 = new Schedule(LocalDateTime.of(2024, 11, 29, 12, 0));

        LOGGER.info("Date time: {}, weekDay: {}", arrivalTime1.getDateTime(), arrivalTime1.getWeekDay());
        LOGGER.info("Date time: {}, weekDay: {}", departureTime2.getDateTime(), departureTime2.getWeekDay());

        //complex enum
        WeekDay weekDay = arrivalTime1.getWeekDay();
        LOGGER.info("Traffic Level: {}. Operating Hours: {}", weekDay.getTrafficLevel(), weekDay.getOperationHours());

        Flight flight1 = new Flight("A045", "Warsaw", arrivalTime1, departureTime1, gate1);
        Flight flight2 = new Flight("A055", "London", arrivalTime2, departureTime2, gate2);

        //complex enum
        Consumer<FlightType> flightInfoPrinter = flightType -> LOGGER.info("Flight Type: {}. Description: {}. Typical duration: {}",
                flightType.name(), flightType.getDescription(), flightType.getTypicalDuration());
        Arrays.stream(FlightType.values()).forEach(flightInfoPrinter);

        try {
            flight1.sellTicket(ticket1, baggage1);
            flight1.sellTicket(ticket3, baggage3);
            flight2.sellTicket(ticket2, baggage2);
            flight2.sellTicket(ticket4, baggage4);
            flight1.sellTicket(ticket1, baggage1);//Will throw exception
        } catch (TicketAlreadySoldException e) {
            LOGGER.error("Error selling ticket: ", e);
        }

        try {
            flight1.bookSeat(seat1);
            flight2.bookSeat(seat2);
            flight1.bookSeat(seat3);
            flight2.bookSeat(seat4);
            flight2.bookSeat(seat4);
        } catch (SeatAlreadyBookedException e) {
            LOGGER.error("Error booking seat: ", e);
        }

        flight1.assignGate();
        flight2.assignGate();

        flight1.setPassengers(passenger1);
        flight1.setPassengers(passenger3);
        flight2.setPassengers(passenger2);
        flight2.setPassengers(passenger4);

        LOGGER.warn(flight1.findPassengerByPassportNumber(passenger1.getPassportNumber()));

        //Consumer lambda function. Print passengers.
        Consumer<List<Passenger>> printPassengers = passenger -> flight1.getPassengers().forEach(LOGGER::info);
        flight1.printInfoPassenger(flight1.getPassengers(), printPassengers);
        flight2.printInfoPassenger(flight2.getPassengers(), printPassengers);

        //custom lambda function with generic
        CustomFunction<Map<Ticket, Baggage>, Double> printInformationOfBaggage = baggage ->
                flight1.getBaggageMap().values().stream().mapToDouble(Baggage::getWeight).sum();
        LOGGER.info("Total baggage weight: {}kg.", flight1.countTotalBaggageWeight(flight1.getBaggageMap(), printInformationOfBaggage));

        //try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found. ", e);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        LOGGER.debug("Information of flight: {}", flight1);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);

        //polymorphism business method
        Flight.processArrivals(flights);
        Flight.processDepartures(flights);

        //Stream.forEach
        flight1.getTickets().stream()
                .forEach(ticket -> LOGGER.info("Type of class: {}; seat number: {}; passenger: {}",
                        ticket.getClassType().getName(), ticket.getSeatNumber(), ticket.getPassenger().getName()));

        flight1.getSeats().stream()
                .forEach(seat -> LOGGER.info("Numbers of seats: {}", seat.getSeatNumber()));

        flight1.getBaggageMap().entrySet().stream()
                .forEach(ticketBaggageEntry -> LOGGER.info("Ticket: {}. {}", ticketBaggageEntry.getKey(),
                        ticketBaggageEntry.getValue()));

        Terminal terminal = new Terminal("Terminal1");
        terminal.setFlights(flights);

        //Function lambda. Converted flight to string with information about this flight.
        Function<Flight, String> flightSummary = flight -> "Flight number: " + flight.getFlightNumber() + " is flies to "
                + flight.getDestination();
        terminal.printInfoFlight(terminal.getFlights(), flightSummary);

        //Supplier function
        Supplier<Set<Seat>> setSupplier = () -> flight1.getSeats();
        Set<Seat> numbers = flight1.printNumberSeats(setSupplier);
        numbers.forEach(Seat::getSeatNumber);

        //Runnable: flight count display
        Runnable showCountFlights = () -> LOGGER.info("Total flights: {} ", terminal.getFlights().size());
        terminal.executeTask(showCountFlights);

        Airline lotPolishAirline = new Airline("LOT Polish Airlines", "Poland");
        lotPolishAirline.addFlight(flight1);

        Airline americanAirlines = new Airline("American Airlines", "America");
        americanAirlines.addFlight(flight2);

        Airport airport = new Airport("Dubai International Airport", new ArrayList<>(Arrays.asList(terminal)));
        airport.addAirline(lotPolishAirline);
        airport.addAirline(americanAirlines);

        int totalPassengers1 = airport.calculateTotalPassengersOnDate(LocalDate.of(2024, 11, 18));

        LOGGER.debug("Total passengers scheduled for 2024-11-29: {}", totalPassengers1);

        //business method for calculating ticket sales tax.
        TaxCalculateService taxCalculator = new TaxCalculateService();
        BigDecimal totalTaxFlight1 = taxCalculator.calculateTax(flight1.getTickets(), ticket ->
                ticket.calculateTotalCost(ticket.getClassType()).multiply(TaxCalculateService.DUBAI_TAX_RATE));

        LOGGER.info("Final total tax for all tickets in flight1: {}$", totalTaxFlight1);

        BigDecimal totalTaxFlight2 = taxCalculator.calculateTax(flight2.getTickets(), ticket ->
                ticket.calculateTotalCost(ticket.getClassType()).multiply(TaxCalculateService.DUBAI_TAX_RATE)
        );

        LOGGER.info("Final total tax for all tickets in flight2: {}$", totalTaxFlight2);

        List<Passenger> passengerList = new ArrayList<>(Arrays.asList(passenger1, passenger2, passenger3, passenger4));

        //Stream.filter
        List<Ticket> ticketsBusinessClass = flight2.getTickets().stream()
                .filter(ticket -> ticket.getClassType().equals(businessClass))
                .toList();
        LOGGER.info("Ticket of business class {}", ticketsBusinessClass);

        //Stream.map, Stream.collect
        List<String> flight2PassengerNameToUpperCase = flight2.getTickets().stream()
                .map(ticket -> ticket.getPassenger().getName().toUpperCase())
                .collect(Collectors.toList());
        LOGGER.info("Name of passengers in flight2: {}", flight2PassengerNameToUpperCase);

        //Stream.findFirst
        flight2.getPassengers().stream()
                .findFirst()
                .ifPresent(passenger -> LOGGER.info("First passenger: {}", passenger));

        //Stream.count
        long count = flight2.getSeats().stream()
                .count();
        LOGGER.info("Number of booked seats: {}", count);

        //Stream.allMatch
        boolean allMatch = flight2.getPassengers().stream()
                .allMatch(passenger -> {
                    LocalDate today = LocalDate.now();
                    return Period.between(passenger.getDateOfBirth(), today).getYears() >= 18;
                });
        LOGGER.info("All passengers are of legal age: {}", allMatch);

        //Stream.anyMatch
        boolean anyMatch = flight2.getTickets().stream()
                .anyMatch(ticket -> ticket.getBaseCost().compareTo(BigDecimal.valueOf(300)) > 0);
        LOGGER.info("Are there tickets more than 300$: {}", anyMatch);

        //Stream.flatMap
        List<String> numbersFlightOfAirport = airport.getAirlines().stream()
                .flatMap(airline -> airline.getFlights().stream())
                .map(Flight::getFlightNumber)
                .toList();
        LOGGER.info("Flight numbers at the airport {}", numbersFlightOfAirport);

        //Stream.peek
        List<String> allNamesToLowerCase = passengerList.stream()
                .map(passenger -> passenger.getName().toLowerCase())
                .peek(passenger -> LOGGER.info("List of names in lower case {}", passenger))
                .toList();
        LOGGER.info("{}", allNamesToLowerCase);
    }
}
