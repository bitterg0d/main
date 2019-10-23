package seedu.module.model.module;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Module's grade in the module book.
 * Guarantees: immutable; is always valid
 */
public class Grade {
    public static final String MESSAGE_CONSTRAINTS = "Not a valid Grade";

    private String component;
    private String grade;
    private int percentage;

    public Grade(String component, int percentage, String grade) {
        requireNonNull(percentage);
        requireNonNull(component);

        this.component = component;
        this.grade = grade;
        this.percentage = percentage;

    }

    public String getComponent() {
        return this.component;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setValue(String newValue) {
        this.grade = newValue;
    }

    @Override
    public String toString() {
        return grade;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Grade // instanceof handles nulls
                && component.equals(((Grade) other).component)); // state check
    }

    @Override
    public int hashCode() {
        return grade.hashCode();
    }

}
