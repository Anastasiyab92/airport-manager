package com.solvd.airportmanager.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableDemo("Runnable demo"));
        thread1.start();

        Thread thread2 = new ThreadDemo("Thread demo");
        thread2.start();

        ConnectionPool connectionPool = new ConnectionPool(5);
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            executorService.submit(new ConnectionDemo(connectionPool));
        }
        executorService.shutdown();

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            LOGGER.info("{} is running CompletableFuture Task 1", Thread.currentThread().getName());
        });

        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            LOGGER.info("{} is running CompletableFuture Task 2", Thread.currentThread().getName());
        });

        CompletableFuture<Void> tasks = CompletableFuture.allOf(task1, task2);
        tasks.join();
        LOGGER.info("All CompletableFuture tasks completed!");
    }
}
