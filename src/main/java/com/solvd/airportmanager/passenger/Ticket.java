package com.solvd.airportmanager.passenger;

import com.solvd.airportmanager.classtype.ClassType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket implements Checkable {

    private static final Logger LOGGER = LogManager.getLogger(Ticket.class);
    private String seatNumber;
    private BigDecimal baseCost;
    private ClassType classType;
    private Passenger passenger;

    public Ticket(String seatNumber, BigDecimal priceTicket, ClassType classType) {
        this.seatNumber = seatNumber;
        this.baseCost = priceTicket;
        this.classType = classType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public ClassType getClassType() {
        return classType;
    }

    public BigDecimal getBaseCost() {
        return baseCost;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public boolean verify() throws PassengerNotRegisteredException {
        return seatNumber != null && !seatNumber.isEmpty() && baseCost != null && classType != null && passenger.verify();
    }

    // business method with parameter of SuperClass
    public BigDecimal calculateTotalCost(ClassType classType) {
        return classType.calculateCost(baseCost);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "seatNumber='" + seatNumber + '\'' +
                ", baseCost=" + baseCost +
                ", classType=" + classType +
                ", passenger=" + passenger +
                ", totalCost=" + calculateTotalCost(classType) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(seatNumber, ticket.seatNumber) && Objects.equals(classType, ticket.classType) && Objects.equals(passenger, ticket.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, classType, passenger);
    }

    public void printTicketDetails() {
        LOGGER.info("Ticket for passenger: {}\nClass: {}\nPrice: {}\nSeat number: {}",
                passenger.getName(), classType.getName(), classType.calculateCost(getBaseCost()), seatNumber);
    }
}
