package com.example.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private DateUtil() {
        // Private constructor to prevent instantiation
    }

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Convert String to LocalDate
    public static LocalDate parse(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    // Convert LocalDate to String
    public static String format(LocalDate date) {
        return date.format(FORMATTER);
    }

    // Get today's date
    public static LocalDate today() {
        return LocalDate.now();
    }
}
