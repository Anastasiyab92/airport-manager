package flight;

public class AmericanAirlines extends Airline {

    public AmericanAirlines() {
        super("American Airlines");
    }

    @Override
    public String provideServiceDescription() {
        return "American Airlines: Premium in-flight entertainment, comfortable seating, and frequent flyer rewards.";
    }
}
