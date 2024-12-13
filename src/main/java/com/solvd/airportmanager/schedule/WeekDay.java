package com.solvd.airportmanager.schedule;

public enum WeekDay {
    MONDAY("Low traffic", "8:00-22:00"),
    TUESDAY("Moderate traffic", "8:00-22:00"),
    WEDNESDAY("Moderate traffic", "8:00-22:00"),
    THURSDAY("Moderate traffic", "8:00-22:00"),
    FRIDAY("High traffic", "6:00-00:00"),
    SATURDAY("High traffic", "6:00-00:00"),
    SUNDAY("Low traffic", "8:00-22:00");

    private final String trafficLevel;
    private final String operationHours;

    WeekDay(String trafficLevel, String operationHours) {
        this.trafficLevel = trafficLevel;
        this.operationHours = operationHours;
    }

    public String getTrafficLevel() {
        return trafficLevel;
    }

    public String getOperationHours() {
        return operationHours;
    }
}
