package com.solvd.airportmanager.flight;

import java.time.LocalDateTime;

public interface Arrivable {

    LocalDateTime getArrivalTime();

    String getArrivalGate();

    void processArrival();
}
