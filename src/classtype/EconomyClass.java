package classtype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EconomyClass extends ClassType {

    public static final double MAX_WEIGHT_BAGGAGE_ECONOMY = 10.0;

    public EconomyClass() {
        super("Economy class");
    }

    @Override
    public double getMaxBaggageWeight() {
        return MAX_WEIGHT_BAGGAGE_ECONOMY;
    }

    @Override
    public List<Service> getServices() {
        List<Service> serviceEconomyClass = new ArrayList<>();
        serviceEconomyClass.add(new Service("Regular seating", false, true, false,
                MAX_WEIGHT_BAGGAGE_ECONOMY));
        return serviceEconomyClass;
    }

    @Override
    public BigDecimal calculateCost(BigDecimal baseCost) {
        return baseCost;
    }
}

