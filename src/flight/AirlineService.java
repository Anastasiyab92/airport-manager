package flight;

public class AirlineService {

    //business method with parameter of superClass type
    public void printServiceInfo(Airline airline) {
        System.out.println("Airline name " + airline.getName());
        System.out.println("Service Description: " + airline.provideServiceDescription());

    }
}
