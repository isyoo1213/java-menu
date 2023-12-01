package menu.utils;

import menu.constants.ExceptionMessages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {
    private static final String SPACING_STRING = " ";
    private static final String EMPTY_STRING = "";
    private static final String COMMA_SEPARATOR = ",";
    private static final int MINIMUM_COACH_AMOUNT = 2;
    private static final int MAXIMUM_COACH_AMOUNT = 5;

    public String preprocess(String input) {
        if (isNull(input)) {
            ExceptionMessages.NULL_INPUT.throwException();
        }
        return removeSpacing(input);
    }

    private String removeSpacing(String input) {
        return input.replaceAll(SPACING_STRING, EMPTY_STRING);
    }

    public List<String> convertToCoachNames(String coachNames) {
        if (isEmpty(coachNames)) {
            ExceptionMessages.EMPTY_INPUT.throwException();
        }
        if (isWrongSeparator(coachNames)) {
            ExceptionMessages.WRONG_NAMES_FORMAT.throwException();
        }
        List<String> convertedCoachNames = Stream.of(coachNames.split(COMMA_SEPARATOR))
                .collect(Collectors.toList());
        if (isWrongCoachNamesAmount(convertedCoachNames)) {
            ExceptionMessages.WRONG_COACHES_AMOUNT.throwException();
        }
        return convertedCoachNames;
    }

    public List<String> convertToHateMenus(String hateMenus) {
        if (hateMenus.isEmpty()) {
            return List.of(hateMenus);
        }
        return Stream.of(hateMenus.split(COMMA_SEPARATOR))
                .collect(Collectors.toList());
    }

    private boolean isWrongCoachNamesAmount(List<String> convertedCoachNames) {
        return convertedCoachNames.size() < MINIMUM_COACH_AMOUNT || convertedCoachNames.size() > MAXIMUM_COACH_AMOUNT;
    }

    private boolean isWrongSeparator(String coachNames) {
        return !coachNames.contains(COMMA_SEPARATOR);
    }

    private boolean isEmpty(String coachNames) {
        return coachNames.isEmpty();
    }

    private boolean isNull(String input) {
        return input == null;
    }
}
