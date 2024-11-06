package airport;

import flight.Flight;

import java.time.LocalDate;

public class Terminal {
    private String name;
    private Flight[] flights;

    public Terminal(String name, Flight[] flights) {
        this.name = name;
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public int calculateCountPassengersOnDate(LocalDate date){
        int countPassengers = 0;
        for(Flight flight : flights){
            countPassengers += flight.getPassengerCountOnDate(date);
        }
        return countPassengers;
    }
}
