package flight;

public class LotPolishAirlines extends Airline {

    private String country;

    public LotPolishAirlines() {
        super("LOT Polish Airlines");
        this.country = "Poland";
    }

    @Override
    public String provideServiceDescription() {
        return "LOT Polish Airlines: Polish cuisine, priority boarding for business class, and great international connections. "
                + "Country of origin: " + country;
    }
}
