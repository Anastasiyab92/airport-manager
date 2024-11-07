package passenger;

import java.math.BigDecimal;

public class Ticket {
   private String seatNumber;
   private String classType;
   private BigDecimal price;
   private Passenger passenger;

    public Ticket(String seatNumber, String classType, BigDecimal price) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getClassType() {
        return classType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
