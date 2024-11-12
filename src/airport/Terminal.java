package airport;

import flight.Flight;

import java.time.LocalDate;

public class Terminal {

    protected String name;
    private Flight[] flights;

    public Terminal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public int calculateCountPassengersOnDate(LocalDate date) {
        int countPassengers = 0;
        for (Flight flight : flights) {
            countPassengers += flight.getPassengerCountOnDate(date);
        }
        return countPassengers;
    }
}
