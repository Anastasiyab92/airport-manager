package main.java.com.solvd.airport.passenger;

//if the main.java.com.solvd.airport.passenger is not registered
public class PassengerNotRegisteredException extends Exception {

    public PassengerNotRegisteredException(String message) {
        super(message);
    }
}
