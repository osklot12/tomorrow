package no.ntnu.oskarlothe.model.regionstrategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NoRegionStrategy implements RegionStrategy {
    public NoRegionStrategy() {

    }

    @Override
    public String getDateAsNumbers(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("no"));

        String dateString = date.format(formatter);

        return dateString;
    }

    @Override
    public String getDateAsWords(LocalDate date) {
        String weekday = date.getDayOfWeek().toString();

        String weekdayFormatted = weekday.substring(0, 1).toUpperCase() + weekday.substring(1).toLowerCase();
        
        String dayOfMonth = Integer.toString(date.getDayOfMonth());

        String month = date.getMonth().toString();

        String monthFormatted = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();

        String year = Integer.toString(date.getYear());

        return weekdayFormatted + ", " + dayOfMonth + ". " + monthFormatted + " " + year;
    }
}
