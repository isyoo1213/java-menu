package menu.constants;

public enum ExceptionMessages {
    NULL_INPUT("null은 입력할 수 없습니다."),
    EMPTY_INPUT("값을 입력해주세요."),
    WRONG_NAMES_FORMAT("코치는 최소 2명으로, 구분자는 쉼표(,)를 사용해주세요."),
    WRONG_NAMES_LENGTH("이름은 2~4글자로 입력해주세요."),
    WRONG_COACHES_AMOUNT("코치는 2~5명으로 입력해주세요."),
    DUPLICATED_COACH_NAMES("중복된 코치는 입력할 수 없습니다."),
    DUPLICATED_MENUS("중복된 메뉴는 입력할 수 없습니다."),
    NON_EXISTING_MENUS("존재하지 않는 메뉴가 포함되어 있습니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessages;

    ExceptionMessages(String exceptionMessages) {
        this.exceptionMessages = ERROR_TAG + exceptionMessages;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessages);
    }
}
