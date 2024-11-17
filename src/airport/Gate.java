package airport;

public class Gate implements Boardable {

    protected String gateNumber;

    public Gate(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    @Override
    public void board() {
        System.out.println("Boarding at gate " + gateNumber + ".");
    }
}
