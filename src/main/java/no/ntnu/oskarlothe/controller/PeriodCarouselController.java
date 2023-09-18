package no.ntnu.oskarlothe.controller;

import java.time.LocalDate;

import no.ntnu.oskarlothe.controller.command.DisplayDayCommand;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.view.StyleApplier;
import no.ntnu.oskarlothe.view.buttons.DayNavigationButton;
import no.ntnu.oskarlothe.view.containers.PeriodCarousel;

/**
 * A class representing a controller for the PeriodCarousel class.
 * The controller handles all actions related to altering the content of the
 * carousel.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class PeriodCarouselController {
    private PeriodCarousel carousel;

    private int range;

    private int offset;

    /**
     * Constructor for the PeriodCarouselController.
     * 
     * @param carousel the navigator controlled
     */
    public PeriodCarouselController(PeriodCarousel carousel) {
        if (carousel == null) {
            throw new IllegalArgumentException(
                    "Cannot create PeriodCarouselController, because PeriodCarousel is null.");
        }

        this.carousel = carousel;

        this.range = 4;

        this.offset = -1;
    }

    /**
     * Returns the PeriodCarousel object held by the controller.
     * 
     * @return the controlled carousel
     */
    public PeriodCarousel getPeriodCarousel() {
        return this.carousel;
    }

    /**
     * Returns the offset of the controller.
     * 
     * @return current offset value
     */
    public int getOffset() {
        return this.offset;
    }

    /**
     * Returns the range of the carousel.
     * 
     * @return range of carousel
     */
    public int getRange() {
        return this.range;
    }

    /**
     * Sets the range of the content to be displayed.
     * 
     * @param range value of range, bigger than 0
     */
    public void setRange(int range) {
        if (range < 1) {
            throw new IllegalArgumentException("Cannot set range, because range is smaller than 1.");
        }
    }

    /**
     * Sets the offset of the content to be displayed.
     * The offset pushes the toggled period with the offset.
     * 
     * @param offset any integer
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Adds a single button to the carousel.
     * 
     * @param day day to add
     * @param toggled indicates if the day is toggled or not
     * @param dominant indicates wheter the day is dominant or not
     * @param command the command associated with the button
     */
    public void addDayButton(Day day, boolean toggled, boolean dominant, DisplayDayCommand command) {
        if (day == null) {
            throw new IllegalArgumentException("Cannot add button, because day is null.");
        }

        DayNavigationButton dayButton = new DayNavigationButton(day);

        dayButton.setOnAction(event -> command.execute());

        if (!dominant) {
            StyleApplier.addStyleClass(dayButton, "submissive");
        } else {
            StyleApplier.addStyleClass(dayButton, "dominant");
        }

        if (day.getDate().isAfter(LocalDate.now())) {
            StyleApplier.addStyleClass(dayButton, "future-button");
        } else if (day.getDate().isBefore(LocalDate.now())) {
            StyleApplier.addStyleClass(dayButton, "past-button");
        } else {
            StyleApplier.addStyleClass(dayButton, "today-button");
        }

        if (toggled) {
            StyleApplier.addStyleClass(dayButton, "toggled-state");
        }

        this.carousel.getChildren().add(dayButton);
    }
}
