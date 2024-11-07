package flight;

public class Airline {
    private String name;
    private Flight[] flights;

    public Airline(String name) {
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
}
