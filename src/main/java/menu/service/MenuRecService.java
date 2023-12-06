package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constants.MenuConstants;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.HateMenu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Coach, String> selectMenus(Coaches coaches, MenuConstants selectedCategory) {
        Map<Coach, String> menuResult = new LinkedHashMap<>();
        for (Map.Entry<Coach, HateMenu> coachInfo : coaches.provideCoachesInfo().entrySet()) {
            String selectedMenu = selectMenu(selectedCategory, coachInfo);
            menuResult.put(coachInfo.getKey(), selectedMenu);
        }
        return menuResult;
    }

    private String selectMenu(MenuConstants selectedCategory, Map.Entry<Coach, HateMenu> coachInfo) {
        String selectedMenu = null;
        boolean continueRec = true;
        while (continueRec) {
            selectedMenu = Randoms.shuffle(selectedCategory.getMenus()).get(0);
            if (!coachInfo.getValue().hasMenu(selectedMenu)) {
                continueRec = false;
            }
        }
        return selectedMenu;
    }
}
