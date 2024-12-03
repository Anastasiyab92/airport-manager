package com.solvd.airportmanager.classtype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BusinessClass extends ClassType {

    // this field belongs class and can't be changed
    public final static double MAX_WEIGHT_BAGGAGE_BUSINESS = 50.0;

    public BusinessClass() {
        super("Business class");
    }

    @Override
    public double getMaxBaggageWeight() {
        return MAX_WEIGHT_BAGGAGE_BUSINESS;
    }

    @Override
    public List<Service> getServices() {
        List<Service> servicesBusinessClass = new ArrayList<>();
        servicesBusinessClass.add(new Service("Comfortable seating", true, true, true,
                MAX_WEIGHT_BAGGAGE_BUSINESS));
        return servicesBusinessClass;
    }

    //"Comfortable seating", true, true, true, MAX_WEIGHT_BAGGAGE_BUSINESS
    @Override
    public BigDecimal calculateCost(BigDecimal baseCost) {
        return baseCost.multiply(BigDecimal.valueOf(1.5));
    }
}
