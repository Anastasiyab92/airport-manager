package main.java.com.solvd.airport.schedule;

import java.time.LocalDateTime;

/*
class Schedule is final. It doesn't need to be expanded,
because it's a base concept.
 */
public final class Schedule {

    // dateTime can't be changed.
    public final LocalDateTime dateTime;

    public Schedule(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
