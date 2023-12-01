package menu.model;

import menu.constants.ExceptionMessages;

public class Coach {
    private final int MINIMUM_NAME_LENGTH = 2;
    private final int MAXIMUM_NAME_LENGTH = 4;

    private final String coachName;

    public Coach(String coachName) {
        validate(coachName);
        this.coachName = coachName;
    }

    private void validate(String coachName) {
        if (!isBetweenTwoAndFour(coachName)) {
            ExceptionMessages.WRONG_NAMES_LENGTH.throwException();
        }
    }

    private boolean isBetweenTwoAndFour(String coachName) {
        return (coachName.length() >= MINIMUM_NAME_LENGTH && coachName.length() <= MAXIMUM_NAME_LENGTH);
    }
}
