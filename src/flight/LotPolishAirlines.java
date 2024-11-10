package flight;

public class LotPolishAirlines extends Airline {

    public LotPolishAirlines() {
        super("LOT Polish Airlines");
    }

    @Override
    public String provideServiceDescription() {
        return "LOT Polish Airlines: Polish cuisine, priority boarding for business class, and great international connections.";
    }
}
