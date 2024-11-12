package flight;

public class AmericanAirlines extends Airline {

    private String frequentFlyerProgram;

    public AmericanAirlines() {
        super("American Airlines");
        this.frequentFlyerProgram = "Advantage";
    }

    @Override
    public String provideServiceDescription() {
        return "American Airlines: Premium in-flight entertainment, comfortable seating, " + "and rewards through the "
                + frequentFlyerProgram + " frequent flyer program.";
    }
}
