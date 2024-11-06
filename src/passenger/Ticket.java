package passenger;

import java.math.BigDecimal;

public class Ticket {
   private String seatNumber;
   private String classType;
   private BigDecimal price;
   private Passenger passenger;

    public Ticket(String seatNumber, String classType, BigDecimal price, Passenger passenger) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.price = price;
        this.passenger = passenger;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
