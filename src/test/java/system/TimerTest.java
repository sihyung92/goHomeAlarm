package system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.Time;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TimerTest {

    @ParameterizedTest
    @DisplayName("Timer가 남은 초를 잘 계산해주는지 확인한다")
    @CsvSource(value = {"16,0,0,7200","15,30,30,8970","12,0,1,21599"})
    void until(int hour24, int minute, int second, long expectedSeconds) {
        Timer timer = new Timer();
        LocalTime startTime = LocalTime.of(hour24, minute, second);
        assertThat(timer.until(startTime, LocalTime.of(18,0,0))).isEqualTo(expectedSeconds);
    }
}