package classtype;

import java.math.BigDecimal;

public class BusinessClass extends ClassType {

    public BusinessClass() {
        super("Business class");
    }

    @Override
    public Service[] getServices() {
        return new Service[]{
                new Service("Comfortable seating", true, true, true, 20.0)

        };
    }

    @Override
    public BigDecimal calculateCost(BigDecimal baseCost) {
        return baseCost.multiply(BigDecimal.valueOf(1.5));
    }
}
