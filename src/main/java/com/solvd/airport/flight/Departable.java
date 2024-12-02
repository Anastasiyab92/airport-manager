package main.java.com.solvd.airport.flight;

import java.time.LocalDateTime;

public interface Departable {

    LocalDateTime getDepartureTime();

    String getDepartureGate();

    void processDeparture();
}
