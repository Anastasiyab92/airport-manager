package com.solvd.airportmanager.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDemo extends Thread {

    private static final Logger LOGGER = LogManager.getLogger(ThreadDemo.class);
    private final String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        LOGGER.info("{} is executing task: {}", getName(), threadName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
