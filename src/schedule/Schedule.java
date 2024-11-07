package schedule;

import java.time.LocalDateTime;

public class Schedule {
    private LocalDateTime dateTime;

    public Schedule(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
