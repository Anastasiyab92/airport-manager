package passenger;

import classtype.ClassType;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {

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
        System.out.println("Ticket for passenger: " + passenger.getName());
        System.out.println("Class: " + classType.getName());
        System.out.println("Price: " + classType.calculateCost(baseCost));
        System.out.println("Seat number: " + seatNumber);
    }
}
