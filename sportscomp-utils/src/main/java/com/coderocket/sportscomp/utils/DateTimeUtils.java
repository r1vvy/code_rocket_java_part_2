package com.coderocket.sportscomp.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeUtils {
    public static LocalDate formatStringAsLocalDate(String toFormat) {
        return LocalDate.parse(toFormat, DateTimeFormatter.ISO_DATE);
    }

    public static String formatDateTimeAsPattern(LocalDateTime date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
