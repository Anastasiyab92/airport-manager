package classtype;

import java.util.Objects;

public abstract class ClassType {
    protected String name;
    protected double baggageAllowance;

    public ClassType(String name, double baggageAllowance) {
        this.name = name;
        this.baggageAllowance = baggageAllowance;
    }

    public String getName() {
        return name;
    }

    public double getBaggageAllowance() {
        return baggageAllowance;
    }

    public abstract String getServices();

    @Override
    public String toString() {
        return "ClassType{" +
                "name='" + name + '\'' +
                ", baggageAllowance=" + baggageAllowance +
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
