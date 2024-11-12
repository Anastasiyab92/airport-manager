package passenger;

import classtype.ClassType;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {

    private String seatNumber;
    private BigDecimal priceTicket;
    private ClassType classType;
    private Passenger passenger;

    public Ticket(String seatNumber, BigDecimal priceTicket, ClassType classType) {
        this.seatNumber = seatNumber;
        this.priceTicket = priceTicket;
        this.classType = classType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public ClassType getClassType() {
        return classType;
    }

    public BigDecimal getPriceTicket() {
        return priceTicket;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "seatNumber='" + seatNumber + '\'' +
                ", classType=" + classType +
                ", passenger=" + passenger +
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
        System.out.println("Price: " + priceTicket);
        System.out.println("Seat number: " + seatNumber);
    }
}
