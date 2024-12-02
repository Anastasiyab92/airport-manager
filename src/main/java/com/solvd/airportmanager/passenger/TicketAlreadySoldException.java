package main.java.com.solvd.airport.passenger;

public class TicketAlreadySoldException extends RuntimeException {

    public TicketAlreadySoldException(String message) {
        super(message);
    }
}
