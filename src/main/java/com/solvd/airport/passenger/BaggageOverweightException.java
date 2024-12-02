package main.java.com.solvd.airport.passenger;

// if the baggage is overweight
public class BaggageOverweightException extends RuntimeException {

    public BaggageOverweightException(String message) {
        super(message);
    }
}
