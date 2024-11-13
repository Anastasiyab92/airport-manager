package flight;

import java.util.Arrays;

public class Airline {

    protected String name;
    protected String country;
    private Flight[] flights;

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

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", flights=" + Arrays.toString(flights) +
                '}';
    }
}
