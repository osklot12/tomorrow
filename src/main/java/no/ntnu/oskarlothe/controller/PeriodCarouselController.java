package no.ntnu.oskarlothe.controller;

import java.time.LocalDate;

import no.ntnu.oskarlothe.controller.command.DisplayDayCommand;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.Schedule;
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
    PeriodCarousel carousel;

    int range;

    int offset;

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
     * Displays a given day in the schedule, adjusting other content accordingly.
     * 
     * @param schedule the schedule to display from
     * @param toggle   the day object to be toggled
     */
    public void display(Schedule schedule, Day toggle) {
        if (schedule == null) {
            throw new IllegalArgumentException("Cannot display content, because list is null.");
        }

        if (toggle == null) {
            throw new IllegalArgumentException("Cannot display content, because toggle is null.");
        }

        for (int i = this.offset; i < this.range + this.offset; i++) {
            Day day = schedule.getDay(toggle.getDate().plusDays(i));

            boolean toggled = false;
            if (toggle.getDate().equals(day.getDate())) {
                toggled = true;
            }

            this.addButton(day, toggled);
        }
    }

    /**
     * Adds a single button to the carousel.
     * 
     * @param day day to add
     */
    private void addButton(Day day, boolean toggled) {
        if (day == null) {
            throw new IllegalArgumentException("Cannot add button, because day is null.");
        }

        DayNavigationButton dayButton = new DayNavigationButton(day);

        DisplayDayCommand command = new DisplayDayCommand(day);

        dayButton.setOnAction(event -> command.execute());

        if (day.getDate().isAfter(LocalDate.now())) {
            StyleApplier.removeStyleClass(dayButton, "past-button");
            StyleApplier.removeStyleClass(dayButton, "today-button");
            StyleApplier.addStyleClass(dayButton, "future-button");
        } else if (day.getDate().isBefore(LocalDate.now())) {
            StyleApplier.removeStyleClass(dayButton, "today-button");
            StyleApplier.removeStyleClass(dayButton, "future-button");
            StyleApplier.addStyleClass(dayButton, "past-button");
        } else {
            StyleApplier.removeStyleClass(dayButton, "past-button");
            StyleApplier.removeStyleClass(dayButton, "future-button");
            StyleApplier.addStyleClass(dayButton, "today-button");
        }

        if (toggled) {
            StyleApplier.addStyleClass(dayButton, "toggled-state");
        }

        this.carousel.getChildren().add(dayButton);
    }

    public void toggle(Day day) {

    }
}
