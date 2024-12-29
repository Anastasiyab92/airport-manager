package com.solvd.airportmanager.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionDemo implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionDemo.class);
    private final ConnectionPool connectionPool;

    public ConnectionDemo(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        try {
            Connection connection = connectionPool.obtainConnection();
            LOGGER.info("{} obtained {}", Thread.currentThread().getName(), connection.getName());
            Thread.sleep(3000);
            connectionPool.releaseConnection(connection);
            LOGGER.info("{} released {}", Thread.currentThread().getName(), connection.getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
