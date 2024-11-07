package passenger;

import java.time.LocalDate;

public class Passenger {
    private String name;
    private String passportNumber;
    private LocalDate dateOfBirth;

    public Passenger(String name, String passportNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
