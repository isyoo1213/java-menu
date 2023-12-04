package menu.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Coaches {

    private final Map<Coach, HateMenu> coaches = new LinkedHashMap<>();

    public void addCoach(Coach newCoach, HateMenu hateMenu) {
        coaches.put(newCoach, hateMenu);
    }

    public HateMenu provideCoachHateMenu(Coach coach) {
        return coaches.get(coach);
    }
}
