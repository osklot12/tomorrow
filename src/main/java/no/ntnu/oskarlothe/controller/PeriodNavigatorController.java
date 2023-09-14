package no.ntnu.oskarlothe.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.ntnu.oskarlothe.controller.command.DisplayDayCommand;
import no.ntnu.oskarlothe.controller.command.SetOffsetCommand;
import no.ntnu.oskarlothe.model.Day;
import no.ntnu.oskarlothe.model.Schedule;
import no.ntnu.oskarlothe.view.buttons.NextNavigationButton;
import no.ntnu.oskarlothe.view.buttons.PreviousNavigationButton;
import no.ntnu.oskarlothe.view.containers.PeriodCarousel;
import no.ntnu.oskarlothe.view.layout.PeriodNavigator;

/**
 * A class representing a controller for the PeriodNavigator.
 * The PeriodNavigatorController is the 'engine' for navigating a spesific
 * schedule.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class PeriodNavigatorController {
    private PeriodNavigator navigator;

    private PeriodCarouselController carouselController;

    private Schedule schedule;

    private Day toggle;

    /**
     * Constructor for the PeriodNavigatorController class.
     */
    public PeriodNavigatorController(PeriodNavigator navigator) {
        if (navigator == null) {
            throw new IllegalArgumentException("Cannot create PeriodNavigatorController, because navigator is null.");
        }

        this.navigator = navigator;

        this.schedule = new Schedule();

        this.carouselController = new PeriodCarouselController(this.navigator.getPeriodCarousel());

        LocalDate date = LocalDate.parse("2023-09-14");

        this.toggle = this.schedule.getDay(date);

        this.setToggle(this.schedule.getDay(date));
    }

    /**
     * Constructor for the PeriodNavigatorController class.
     * 
     * @param schedule the schedule to navigate
     * @param toggle   the day to toggle
     */
    public PeriodNavigatorController(PeriodNavigator navigator, Schedule schedule, Day toggle) {
        if (navigator == null) {
            throw new IllegalArgumentException("Cannot create PeriodNavigatorController, because navigator is null.");
        }

        if (schedule == null) {
            throw new IllegalArgumentException("Cannot create PeriodNavigatorController, because schedule is null.");
        }

        if (toggle == null) {
            throw new IllegalArgumentException("Cannot create PeriodNavigatorController, because toggle is null.");
        }

        this.navigator = navigator;

        this.schedule = schedule;

        this.toggle = toggle;

        this.setToggle(toggle);
    }

    /**
     * Returns the navigator of the controller.
     * 
     * @return navigator associated with the controller
     */
    public PeriodNavigator getNavigator() {
        return this.navigator;
    }

    /**
     * Returns the schedule of the controller.
     * 
     * @return schedule associated with the controller
     */
    public Schedule getSchedule() {
        return this.schedule;
    }

    /**
     * Returns the day in toggle.
     * 
     * @return toggled day
     */
    public Day getToggle() {
        return this.toggle;
    }

    /**
     * Sets the toggle of the controller.
     * 
     * @param toggle day to toggle
     */
    public void setToggle(Day toggle) {
        if (toggle == null) {
            throw new IllegalArgumentException("Cannot set toggle, because toggle is null.");
        }

        int relativeOffset = (int) ChronoUnit.DAYS.between(this.toggle.getDate(), toggle.getDate());

        this.carouselController.setOffset(this.carouselController.getOffset() - relativeOffset);

        this.toggle = toggle;

        this.displayCarousel();
    }

    /**
     * Returns the most dominant month of the carousel.
     * This means that the method returns the month which has most occurences in the
     * interval of dates.
     * If two months occur equally amount of times, then the first detected will be
     * dominant.
     * 
     * @return most dominant month, null if interval is empty
     */
    private Month getDominantMonthFromCarousel() {
        List<LocalDate> interval = this.getCarouselInterval();

        Map<Month, Integer> scores = new HashMap<>();

        interval.forEach(
                (date) -> {
                    Month month = date.getMonth();

                    if (!scores.containsKey(month)) {
                        scores.put(month, 1);
                    } else {
                        int currentScore = scores.get(month);
                        scores.put(month, currentScore + 1);
                    }
                });

        Entry<Month, Integer> maxEntry = null;

        for (Entry<Month, Integer> entry : scores.entrySet()) {
            if ((maxEntry == null) || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        if (!(maxEntry == null)) {
            return maxEntry.getKey();
        }

        return null;
    }

    /**
     * Returns the most dominant year of the carousel.
     * This means that the method returns the year that which has most occurences in
     * the interval of dates.
     * If two years occur equally amount of times, then the first detected will be
     * dominant.
     * 
     * @return most dominant year, -1 if interval is empty
     */
    private int getDominantYearFromCarousel() {
        List<LocalDate> interval = this.getCarouselInterval();

        Map<Integer, Integer> scores = new HashMap<>();

        interval.forEach(
                (date) -> {
                    int year = date.getYear();

                    if (!scores.containsKey(year)) {
                        scores.put(year, 1);
                    } else {
                        int currentScore = scores.get(year);
                        scores.put(year, currentScore + 1);
                    }
                });

        Entry<Integer, Integer> maxEntry = null;

        for (Entry<Integer, Integer> entry : scores.entrySet()) {
            if ((maxEntry == null) || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        if (!(maxEntry == null)) {
            return maxEntry.getKey();
        }

        return -1;
    }

    /**
     * Sets the carousel offset relative to the current value.
     * 
     * @param offset offset relative to current value
     */
    public void setRelativeCarouselOffset(int offset) {
        this.carouselController.setOffset(this.carouselController.getOffset() + offset);

        this.displayCarousel();
    }

    /**
     * Returns the list of dates displayed in the PeriodCarousel.
     * 
     * @return interval of dates
     */
    private List<LocalDate> getCarouselInterval() {
        List<LocalDate> interval = new ArrayList<>();

        int offset = this.carouselController.getOffset();
        int range = this.carouselController.getRange();
        for (int i = offset; i < range + offset; i++) {
            LocalDate date = this.toggle.getDate().plusDays(i);

            interval.add(date);
        }

        return interval;
    }

    /**
     * Renders the content of the carousel from a schedule, based on the state of
     * the controller. The method calls a render on the PeriodDisplay as well, since
     * the PeriodDisplay is dependent on the content of the carousel.
     */
    private void displayCarousel() {
        PeriodCarousel carousel = this.carouselController.getPeriodCarousel();

        carousel.getChildren().clear();

        PreviousNavigationButton previousButton = new PreviousNavigationButton();

        SetOffsetCommand previousCommand = new SetOffsetCommand(this, -1);

        previousButton.setOnAction(event -> previousCommand.execute());

        carousel.getChildren().add(previousButton);

        List<LocalDate> interval = this.getCarouselInterval();
        interval.forEach(
                (date) -> {
                    Day day = this.schedule.getDay(date);

                    boolean toggled = false;
                    if (toggle.getDate().equals(day.getDate())) {
                        toggled = true;
                    }

                    DisplayDayCommand dayButtonCommand = new DisplayDayCommand(day, this);

                    boolean dominant = false;
                    if (day.getDate().getMonth().equals(this.getDominantMonthFromCarousel())) {
                        dominant = true;
                    }

                    this.carouselController.addDayButton(day, toggled, dominant, dayButtonCommand);
                });

        NextNavigationButton nextButton = new NextNavigationButton();

        SetOffsetCommand nextCommand = new SetOffsetCommand(this, 1);

        nextButton.setOnAction(event -> nextCommand.execute());

        carousel.getChildren().add(nextButton);

        this.updatePeriodDisplay();
    }

    /**
     * Updates the PeriodDisplay to display the right period.
     */
    private void updatePeriodDisplay() {
        Month dominantMonth = this.getDominantMonthFromCarousel();

        int dominantYear = this.getDominantYearFromCarousel();

        String displayText = dominantMonth.toString() + ", " + dominantYear;

        this.getNavigator().getMonthAndCalendar().setPeriodDisplayText(displayText);
    }

}
