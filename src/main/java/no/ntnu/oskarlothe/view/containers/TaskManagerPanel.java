package no.ntnu.oskarlothe.view.containers;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import no.ntnu.oskarlothe.view.StyleApplier;
import no.ntnu.oskarlothe.view.labels.RegularBoldTitle;
import no.ntnu.oskarlothe.view.labels.SmallBoldTitle;

/**
 * A class representing a panel for the TaskManager component in JavaFX.
 * A TaskManagerPanel contains a label and some content related to the label.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class TaskManagerPanel extends VBox {
    private RegularBoldTitle label;

    private SmallBoldTitle sublabel;

    private TaskManagerBox box;

    public TaskManagerPanel() {
        super();

        this.box = new TaskManagerBox();

        StyleApplier.addStyleClass(this, "task-manager-panel");
        StyleApplier.addStyleSheet(this);
        StyleApplier.addStyleClass(this, "task-manager-child");
        StyleApplier.applyApplicationStyle(this);

        this.init();
    }

    /**
     * Constructor for the TaskManagerPanel class.
     * 
     * @param label the label of the panel
     */
    public TaskManagerPanel(String label, String sublabel) {
        super();

        this.label = new RegularBoldTitle(label);

        this.sublabel = new SmallBoldTitle(sublabel);

        this.box = new TaskManagerBox();

        StyleApplier.addStyleClass(this, "task-manager-panel");
        StyleApplier.addStyleSheet(this);
        StyleApplier.addStyleClass(this, "task-manager-child");
        StyleApplier.applyApplicationStyle(this);

        this.init();
    }

    /**
     * Initializes the components
     */
    private void init() {
        if (!(this.label == null)) {
            this.getChildren().add(this.label);
        }

        if (!(this.sublabel == null)) {
            this.getChildren().add(this.sublabel);
        }

        this.getChildren().add(this.box);
    }

    /**
     * Adds a component to the panel.
     * 
     * @param component JavaFX component to add
     * @return true if successfully added, false if not
     */
    public boolean addComponent(Node component) {
        return this.box.add(component);
    }

    /**
     * Returns the content of the panel.
     * 
     * @return content of panel
     */
    public List<Node> getContent() {
        return this.box.getChildren();
    }
}
