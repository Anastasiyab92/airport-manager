package passenger;

import java.time.LocalDate;

public class RegularPassenger extends Passenger {

    public RegularPassenger(String name, String passportNumber, LocalDate dateOfBirth) {
        super(name, passportNumber, dateOfBirth);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPassportNumber() {
        return super.getPassportNumber();
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public String passengerType() {
        return "Regular passenger.";
    }
}