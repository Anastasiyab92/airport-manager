package com.solvd.airportmanager.customlambdafunction;

@FunctionalInterface
public interface CustomFunction<T, R> {

    R apply(T t);
}
