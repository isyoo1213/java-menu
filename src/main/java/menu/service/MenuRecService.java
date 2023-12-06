package menu.service;

import menu.constants.MenuConstants;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.HateMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuRecService {

    public List<Coach> saveCoaches(List<String> convertedCoachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String convertedCoachName : convertedCoachNames) {
            Coach coach = new Coach(convertedCoachName);
            coaches.add(coach);
        }
        return coaches;
    }

    public HateMenu saveHateMenus(List<String> convertedHateMenus) {
        return new HateMenu(convertedHateMenus);
    }

    public Coaches saveCoachesInfo(List<Coach> validCoaches, List<HateMenu> validHateMenus) {
        Coaches coaches = new Coaches();
        for (int i = 0; i < validCoaches.size(); i++) {
            coaches.addCoach(validCoaches.get(i), validHateMenus.get(i));
        }
        return coaches;
    }

    public MenuConstants selectCategory(int categoryNumber) {
        return MenuConstants.getCategoryByNumber(categoryNumber);
    }
}
