package no.ntnu.oskarlothe.controller.command;

import no.ntnu.oskarlothe.controller.PeriodCarouselController;
import no.ntnu.oskarlothe.controller.PeriodNavigatorController;
import no.ntnu.oskarlothe.view.layout.PeriodNavigator;

/**
 * A class representing a command for setting the offset of a PeriodCarousel
 * object.
 * The SetOffsetCommand together with navigation buttons in the UI, can achieve
 * a navigation behaviour of the days.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class SetOffsetCommand implements Command {
    private PeriodNavigatorController controller;

    private int steps;

    /**
     * Constructor for the SetOffsetCommand class.
     * Positive step values will navigate forwards in the list, while negative ones
     * will navigate backwards.
     * 
     * @param controller the controller to link to
     * @param steps      amount of steps to navigate
     */
    public SetOffsetCommand(PeriodNavigatorController controller, int steps) {
        if (controller == null) {
            throw new IllegalArgumentException("Cannot create SetOffsetCommand, because controller is null.");
        }

        this.controller = controller;
        this.steps = steps;
    }

    public void execute() {
        this.controller.setRelativeCarouselOffset(this.steps);
    }
}
