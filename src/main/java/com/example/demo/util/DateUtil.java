package com.example.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Convert String → LocalDate
    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    // Convert LocalDate → String
    public static String formatDate(LocalDate date) {
        return date.format(FORMATTER);
    }

    // Check if given date is in future
    public static boolean isFutureDate(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }

    // Check if given date is in past
    public static boolean isPastDate(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }
}
