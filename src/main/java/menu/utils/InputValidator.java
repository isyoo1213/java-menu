package menu.utils;

import menu.constants.ExceptionMessages;

public class InputValidator {

    public String preprocess(String input) {
        if (isNull(input)) {
            ExceptionMessages.NULL_INPUT.throwException();
        }
        removeSpacing(input);
        return input;
    }

    private void removeSpacing(String input) {
        input.replaceAll(" ", "");
    }

    private boolean isNull(String input) {
        return input == null;
    }
}
