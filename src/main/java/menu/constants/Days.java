package menu.constants;

public enum Days {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    THURSDAY("수요일"),
    WEDNESDAY("목요일"),
    FRIDAY("금요일");

    Days(String dayName) {
        this.dayName = dayName;
    }

    public final String dayName;
}
