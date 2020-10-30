package system;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Timer {
    public long until(LocalTime startTime, LocalTime endTime) {
        return ChronoUnit.SECONDS.between(startTime, endTime);
    }
}
