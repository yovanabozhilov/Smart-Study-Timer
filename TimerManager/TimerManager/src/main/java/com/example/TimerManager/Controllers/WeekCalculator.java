package com.example.TimerManager.Controllers;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class WeekCalculator {

    // Modify this method to accept LocalDate
    public static LocalDate getStartOfWeek(LocalDate date) {
        // Get the start of the week based on the given date
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate startOfWeek = date.with(weekFields.dayOfWeek(), 1); // Adjust for Monday as the first day of the week
        return startOfWeek;
    }

    // Modify this method to accept LocalDate
    public static LocalDate getEndOfWeek(LocalDate date) {
        // Get the end of the week based on the given date
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        LocalDate endOfWeek = date.with(weekFields.dayOfWeek(), 7); // Adjust for Sunday as the last day of the week
        return endOfWeek;
    }
}

