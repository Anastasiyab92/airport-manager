package main.java.com.solvd.airport.airport;

import java.io.IOException;

public class GateUnavailableException extends IOException {

    public GateUnavailableException(String message) {
        super(message);
    }
}
