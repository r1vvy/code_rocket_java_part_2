package com.coderocket.sportscomp.utils;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public final class DateTimeUtils{
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ISO_DATE;

    public static LocalDate formatStringAsLocalDate(String toFormat) {
        return LocalDate.parse(toFormat, dateFormat);
    }
}
