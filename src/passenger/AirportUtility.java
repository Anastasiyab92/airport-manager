package passenger;

public class AirportUtility {

    // this method belongs class and not an instance of the class
    public static void performCheck(Checkable checkable) {
        if (checkable.verify()) {
            System.out.println("Check passed!");
        } else {
            System.out.println("Check failed.");
        }
    }
}
