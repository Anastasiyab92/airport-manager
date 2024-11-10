package classtype;

public class EconomyClass extends ClassType {

    public EconomyClass(double baggageAllowance) {
        super("Economy class", baggageAllowance);
    }

    @Override
    public String getServices() {
        return "Basic seating, in-flight drinks, 10 kg carry-on baggage.";
    }
}

