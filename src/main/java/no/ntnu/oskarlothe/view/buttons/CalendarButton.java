package no.ntnu.oskarlothe.view.buttons;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import no.ntnu.oskarlothe.view.StyleApplier;
import no.ntnu.oskarlothe.view.colorpalettes.MainColorPalette;

/**
 * A class representing a JavaFX button component for opening the calendar view.
 */
public class CalendarButton extends Button {
    public CalendarButton() {
        super();

        StyleApplier.applyApplicationStyle(this);
        StyleApplier.addStyleSheet(this, "CalendarButton.css");
        StyleApplier.addStyleClass(this, "calendar-button");
        StyleApplier.addStyleClass(this, "clickable");
        

        this.init();
    }

    /**
     * Initializes the component.
     */
    private void init() {
        Text calendarIcon = GlyphsDude.createIcon(FontAwesomeIcons.CALENDAR, "30px");
        MainColorPalette colorPalette = new MainColorPalette();
        calendarIcon.setFill(colorPalette.getMainGray());
        this.setGraphic(calendarIcon);
    }
}
