package com.solvd.airportmanager.passenger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AirportUtility {

    private static final Logger LOGGER = LogManager.getLogger(AirportUtility.class);
    // this method belongs class and not an instance of the class
    public static void performCheck(Checkable checkable) throws PassengerNotRegisteredException {
        if (checkable.verify()) {
            LOGGER.info("Check passed!");
        } else {
            LOGGER.warn("Check your personal data.");
        }
    }
}
