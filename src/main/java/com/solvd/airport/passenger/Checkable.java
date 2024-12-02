package main.java.com.solvd.airport.passenger;

public interface Checkable {

    boolean verify() throws PassengerNotRegisteredException;
}
