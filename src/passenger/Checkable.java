package passenger;

public interface Checkable {

    boolean verify() throws PassengerNotRegisteredException;
}
