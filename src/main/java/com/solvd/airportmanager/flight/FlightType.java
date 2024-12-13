package com.solvd.airportmanager.flight;

public enum FlightType {
    DOMESTIC("Flights within the same country", "1-2 hours"),
    INTERNATIONAL("Flights across countries", "4-12 hours"),
    LONG_HAUL("Intercontinental flights", "+12 hours");

    private final String description;
    private final String typicalDuration;

    FlightType(String description, String typicalDuration) {
        this.description = description;
        this.typicalDuration = typicalDuration;
    }

    public String getTypicalDuration() {
        return typicalDuration;
    }

    public String getDescription() {
        return description;
    }
}
