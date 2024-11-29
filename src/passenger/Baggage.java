package passenger;

import classtype.ClassType;

import java.util.Objects;

public class Baggage {

    private double weight;
    private ClassType classType;

    public Baggage(double weight, ClassType classType) {
        this.weight = weight;
        this.classType = classType;
        checkOverWeight();
    }

    public double getWeight() {
        return weight;
    }

    // this method can't be overrided in subclasses
    public final void checkOverWeight() throws BaggageOverweightException {
        if (weight > classType.getMaxBaggageWeight()) {
            throw new BaggageOverweightException("Baggage is overweight. " + classType.getName() + " allowed: "
                    + classType.getMaxBaggageWeight() + " kg.");
        }
    }

    @Override
    public String toString() {
        return "Weight of baggage = " + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Baggage baggage = (Baggage) o;
        return Double.compare(weight, baggage.weight) == 0 && Objects.equals(classType, baggage.classType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, classType);
    }
}
