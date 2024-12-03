package com.solvd.airportmanager.classtype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ClassType {

    protected String name;
    protected List<Service> services = new ArrayList<>();

    public ClassType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Service> getServices() {
        return services;
    }

    public abstract BigDecimal calculateCost(BigDecimal baseCost);

    public abstract double getMaxBaggageWeight();

    @Override
    public String toString() {
        return "ClassType{" +
                "services=" + services +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassType classType = (ClassType) o;
        return Objects.equals(name, classType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
