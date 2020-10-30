package app;

import system.ClipboardAccessor;
import system.Timer;

import java.time.LocalTime;

public class GoHomeAlarm {
    public static void main(String[] args) {
        ClipboardAccessor clipboardAccessor = new ClipboardAccessor();
        Timer timer = new Timer();

        LocalTime goHomeTime = LocalTime.of(18,0,0);
        long remainSecond = timer.until(LocalTime.now(), goHomeTime);
        long remainHours = remainSecond / (60 * 60);
        long remainMinutes = remainSecond / 60 - remainHours * 60;

        String message = String.format("퇴근까지 남은 시간은 %d시간 %d분, 초로 환산하면 %d초입니다.", remainHours, remainMinutes, remainSecond);

        clipboardAccessor.copy(message);
    }
}
