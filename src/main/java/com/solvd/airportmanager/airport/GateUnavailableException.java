package com.solvd.airportmanager.airport;

import java.io.IOException;

public class GateUnavailableException extends IOException {

    public GateUnavailableException(String message) {
        super(message);
    }
}
