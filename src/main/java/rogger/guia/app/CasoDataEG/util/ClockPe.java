package rogger.guia.app.CasoDataEG.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ClockPe {

    public static String getClockNow() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ZonedDateTime.now(ZoneId.of("America/Lima")));
    }

}
