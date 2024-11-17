package classtype;

import java.math.BigDecimal;

public class EconomyClass extends ClassType {

    public final static double MAX_WEIGHT_BAGGAGE_ECONOMY = 10.0;

    public EconomyClass() {
        super("Economy class");
    }

    @Override
    public Service[] getServices() {
        return new Service[]{
                new Service("Regular seating", false, true, false, MAX_WEIGHT_BAGGAGE_ECONOMY)
        };
    }

    @Override
    public BigDecimal calculateCost(BigDecimal baseCost) {
        return baseCost;
    }
}

