package classtype;

import java.math.BigDecimal;

public class EconomyClass extends ClassType {

    public EconomyClass() {
        super("Economy class");
    }

    @Override
    public Service[] getServices() {
        return new Service[]{
                new Service("Regular seating", false, true, false, 10.0)
        };
    }

    @Override
    public BigDecimal calculateCost(BigDecimal baseCost) {
        return baseCost;
    }
}

