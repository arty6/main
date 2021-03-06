package seedu.address.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's deadline date in the to-do list.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */
public class TaskDate {

    public static final String MESSAGE_DATE_CONSTRAINTS =
            "Dates should be of the format DD-MM, where DD and MM are numbers";
    private static final String SPECIAL_CHARACTERS = "!#$%&'*+/=?`{|}~^.-";
    // alphanumeric and special characters
    private static final String LOCAL_PART_REGEX = "^[\\w" + SPECIAL_CHARACTERS + "]+";
    private static final String DOMAIN_FIRST_CHARACTER_REGEX = "[^\\W_]"; // alphanumeric characters except underscore
    private static final String DOMAIN_MIDDLE_REGEX = "[a-zA-Z0-9.-]*"; // alphanumeric, period and hyphen
    private static final String DOMAIN_LAST_CHARACTER_REGEX = "[^\\W_]$";
    public static final String DATE_VALIDATION_REGEX = LOCAL_PART_REGEX + "@"
            + DOMAIN_FIRST_CHARACTER_REGEX + DOMAIN_MIDDLE_REGEX + DOMAIN_LAST_CHARACTER_REGEX;

    public final String value;

    /**
     * Constructs an {@code TaskDate}.
     *
     * @param date A valid date.
     */
    public TaskDate(String date) {
        requireNonNull(date);
        checkArgument(isValidDate(date), MESSAGE_DATE_CONSTRAINTS);
        value = date;
    }

    /**
     * Returns if a given string is a valid email.
     */
    public static boolean isValidDate(String test) {
        return test.matches(DATE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TaskDate // instanceof handles nulls
                && value.equals(((TaskDate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
