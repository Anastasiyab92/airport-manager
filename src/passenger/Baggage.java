package passenger;

public class Baggage {

    private double weight;

    public Baggage(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    // this method can't be overrided in subclasses
    public final boolean checkOverWeight(double maxWeight) {
        return weight > maxWeight;
    }
}
