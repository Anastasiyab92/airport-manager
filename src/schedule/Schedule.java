package schedule;

import java.time.LocalDateTime;

public class Schedule {

    protected LocalDateTime dateTime;

    public Schedule(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
