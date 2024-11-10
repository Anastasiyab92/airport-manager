package classtype;

public class BusinessClass extends ClassType {

    public BusinessClass(double baggageAllowance) {
        super("Business class", baggageAllowance);
    }

    @Override
    public String getServices() {
        return "Сomfortable seating, premium meals, access to lounge, 20 kg carry-on baggage.";
    }
}
