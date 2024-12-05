package com.solvd.airportmanager.classtype;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Service {

    private String levelSeat;
    private boolean meal;
    private boolean drink;
    private boolean longZone;
    private double weightBaggage;

    public Service(String levelSeat, boolean meal, boolean drink, boolean longZone, double weightBaggage) {
        this.levelSeat = levelSeat;
        this.meal = meal;
        this.drink = drink;
        this.longZone = longZone;
        this.weightBaggage = weightBaggage;
    }

    public String getLevelSeat() {
        return levelSeat;
    }

    public boolean isMeal() {
        return meal;
    }

    public boolean isDrink() {
        return drink;
    }

    public boolean isLongZone() {
        return longZone;
    }

    public double getWeightBaggage() {
        return weightBaggage;
    }

    @Override
    public String toString() {
        return "Service{" +
                "levelSeat='" + levelSeat + '\'' +
                ", meal=" + meal +
                ", drink=" + drink +
                ", longZone=" + longZone +
                ", weightBaggage=" + weightBaggage +
                '}';
    }
}
