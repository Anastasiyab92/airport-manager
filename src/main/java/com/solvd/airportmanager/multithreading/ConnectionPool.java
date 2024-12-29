package com.solvd.airportmanager.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private final BlockingQueue<Connection> pool;

    public ConnectionPool(int size) {
        pool = new ArrayBlockingQueue<>(size);
        for (int i = 1; i <= size; i++) {
            pool.add(new Connection("Connection " + i));
        }
    }

    public Connection obtainConnection() throws InterruptedException {
        return pool.take();
    }

    public void releaseConnection(Connection connection) {
        pool.offer(connection);
    }
}

