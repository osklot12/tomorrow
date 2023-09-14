package no.ntnu.oskarlothe.view.containers;

import javafx.scene.layout.HBox;
import no.ntnu.oskarlothe.view.StyleApplier;

/**
 * A class representing a JavaFX component for a carousel of periods, letting
 * the user navigate nearby periods.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class PeriodCarousel extends HBox {
    /**
     * Constructor for the PeriodCarousel class.
     */
    public PeriodCarousel() {
        super();

        StyleApplier.addStyleClass(this, "period-carousel");
        StyleApplier.addStyleSheet(this, "PeriodCarousel.css");
    }
}
