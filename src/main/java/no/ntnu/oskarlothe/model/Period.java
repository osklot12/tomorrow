package no.ntnu.oskarlothe.model;

import java.time.LocalDateTime;

import no.ntnu.oskarlothe.model.regionstrategy.RegionStrategy;

/**
 * An interface setting rules for bevahiour on all elements representing a
 * period of time.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public interface Period {
    Report generateReport(User creator, LocalDateTime generatedAt);

    String getPeriodAsString(RegionStrategy region);

    boolean add(Task task);
}
