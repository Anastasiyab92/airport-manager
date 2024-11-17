package classtype;

import java.math.BigDecimal;

public class BusinessClass extends ClassType {

    // this field belongs class and can't be changed
    public final static double MAX_WEIGHT_BAGGAGE_BUSINESS = 50.0;

    public BusinessClass() {
        super("Business class");
    }

    @Override
    public Service[] getServices() {
        return new Service[]{
                new Service("Comfortable seating", true, true, true, MAX_WEIGHT_BAGGAGE_BUSINESS)

        };
    }

    @Override
    public BigDecimal calculateCost(BigDecimal baseCost) {
        return baseCost.multiply(BigDecimal.valueOf(1.5));
    }
}
