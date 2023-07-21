package no.ntnu.oskarlothe.model;

/**
 * A class representing a category for doables in the application.
 * The Category class makes it possible to group doables together and put them
 * under a common name and color. Using the category class, the client will find
 * that is now easier to
 * filter out doables in an environment full of all different tasks.
 * 
 * @author Oskar Lothe
 * @version 1.0-SNAPSHOT
 */
public class Category {
    private String label;

    private String colorHex;

    /**
     * Constructor for the Category class.
     * 
     * @param label    the label of the category
     * @param colorHex the color hex code for the category
     */
    public Category(String label, String colorHex) {
        if (label == null || label.isBlank()) {
            throw new IllegalArgumentException("Cannot create category, because label is not defined.");
        }

        if (colorHex == null || !(HexColorValidator.isValidColorHex(colorHex))) {
            throw new IllegalArgumentException(
                    "Cannot create category, because the given color hex is not valid, or is null.");
        }

        this.label = label;
        this.colorHex = colorHex;
    }

    /**
     * Returns the label of the category.
     * 
     * @return label of category
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Returns the color hex code for the category.
     * 
     * @return color hex code
     */
    public String getColorHex() {
        return this.colorHex;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.label.hashCode();
        result = 31 * result + this.colorHex.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Category)) {
            return false;
        }

        Category category = (Category) o;
        return this.label.equals(category.getLabel());
    }
}
