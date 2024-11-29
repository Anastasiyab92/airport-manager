package flight;

import airport.Notifiable;

import java.util.ArrayList;
import java.util.List;

public class Airline implements Notifiable {

    protected String name;
    protected String country;
    private List<Flight> flights = new ArrayList<>();

    public Airline(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public void notification(String message) {
        System.out.println("Airline: " + name + " notification: " + message);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", flights=" + flights +
                '}';
    }
}
