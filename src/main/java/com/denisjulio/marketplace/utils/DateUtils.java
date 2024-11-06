package com.denisjulio.marketplace.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public String formataStrEmTempoRelativo(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        long months = ChronoUnit.MONTHS.between(dateTime, now);
        long days = ChronoUnit.DAYS.between(dateTime, now);
        long hours = ChronoUnit.HOURS.between(dateTime, now);
        long minutes = ChronoUnit.MINUTES.between(dateTime, now);

        if (months > 0) {
            return months + " meses";
        } else if (days > 0) {
            return days + " dias";
        } else if (hours > 0) {
            return hours + " horas";
        } else if (minutes > 0) {
            return minutes + " minutos";
        } else {
            return "agora mesmo";
        }
    }
}
