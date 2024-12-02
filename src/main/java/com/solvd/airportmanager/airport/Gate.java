package main.java.com.solvd.airport.airport;

public class Gate implements Boardable, AutoCloseable {

    protected String gateNumber;
    private boolean isAvailable;

    public Gate(String gateNumber) {
        this.gateNumber = gateNumber;
        isAvailable = true;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void reserveGate() throws GateUnavailableException {
        if (!isAvailable) {
            throw new GateUnavailableException("Gate " + gateNumber + " is unavailable.");
        }
        isAvailable = false;
    }

    @Override
    public void board() {
        System.out.println("Boarding at gate " + gateNumber + ".");
    }

    @Override
    public void close() {
        isAvailable = true; // Automatically release gate when closing
        System.out.println("Gate " + gateNumber + " has been released.");
    }

    @Override
    public String toString() {
        return "number: " + gateNumber;
    }
}
