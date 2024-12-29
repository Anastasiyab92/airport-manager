package com.solvd.airportmanager.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableDemo implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(RunnableDemo.class);
    private final String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        LOGGER.info("Creating {}", threadName);

    }

    @Override
    public void run() {
        LOGGER.info("{} is executing task: {}", Thread.currentThread().getName(), threadName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
