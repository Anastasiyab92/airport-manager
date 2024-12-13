package com.solvd.airportmanager.schedule;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/*
class Schedule is final. It doesn't need to be expanded,
because it's a base concept.
 */
public final class Schedule {

    // dateTime can't be changed.
    private final LocalDateTime dateTime;
    private final WeekDay weekDay;

    public Schedule(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.weekDay = mapToWeekDay(dateTime.getDayOfWeek());
    }

    private WeekDay mapToWeekDay(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> WeekDay.MONDAY;
            case TUESDAY -> WeekDay.TUESDAY;
            case WEDNESDAY -> WeekDay.WEDNESDAY;
            case THURSDAY -> WeekDay.THURSDAY;
            case FRIDAY -> WeekDay.FRIDAY;
            case SATURDAY -> WeekDay.SATURDAY;
            case SUNDAY -> WeekDay.SUNDAY;
        };
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    @Override
    public String toString() {
        return "Schedule dateTime: " + dateTime +
                ", weekDay=" + weekDay;
    }
}
