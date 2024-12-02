package main.java.com.solvd.airport.passenger;

import java.util.Objects;

public class Seat {

    private String seatNumber;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(seatNumber, seat.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber);
    }
}
