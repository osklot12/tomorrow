package no.ntnu.oskarlothe.model.regionstrategy;

import java.time.LocalDate;

/**
 * An interface for region strategies, used for generating different formats of time based on the region.
 */
public interface RegionStrategy {
    /**
     * Returns the given LocalDate object in the format 'dd.MM.yyyy'.
     * 
     * @param date a LocalDate object
     * @return LocalDate object represented by a string
     */
    String getDateAsNumbers(LocalDate date);

    /**
     * Returns the given LocalDate object in the format 'Tuesday, 10. June 2023'
     * 
     * @param date a LocalDate object
     * @return LocalDate object represented by a string
     */
    String getDateAsWords(LocalDate date);
}
