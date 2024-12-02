package main.java.com.solvd.airport.flight;

import java.time.LocalDateTime;

public interface Arrivable {

    LocalDateTime getArrivalTime();

    String getArrivalGate();

    void processArrival();
}
