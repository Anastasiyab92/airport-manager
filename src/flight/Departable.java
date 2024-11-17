package flight;

import java.time.LocalDateTime;

public interface Departable {

    LocalDateTime getDepartureTime();

    String getDepartureGate();

    void processDeparture();
}
