package com.solvd.airportmanager.multithreading;

public class Connection {
    private final String connectionName;

    public Connection(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getName() {
        return connectionName;
    }
}
