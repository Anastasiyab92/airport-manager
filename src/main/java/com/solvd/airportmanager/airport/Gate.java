package com.solvd.airportmanager.airport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gate implements Boardable, AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(Gate.class);
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
        LOGGER.info("Boarding at gate {} .", gateNumber);
    }

    @Override
    public void close() {
        isAvailable = true; // Automatically release gate when closing
        LOGGER.info("Gate {} has been released.",gateNumber);
    }

    @Override
    public String toString() {
        return "number: " + gateNumber;
    }
}
