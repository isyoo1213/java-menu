package menu.model;

import menu.constants.ExceptionMessages;
import menu.constants.MenuConstants;

import java.util.List;

public class HateMenu {
    private final List<String> hateMenus;

    public HateMenu(List<String> hateMenus) {
        validate(hateMenus);
        this.hateMenus = List.copyOf(hateMenus);
    }

    private void validate(List<String> hateMenus) {
        boolean isNonHateMenus = false;
        if (hateMenus.size() == 0) {
            isNonHateMenus = true;
        }
        if (!isNonHateMenus && isDuplicated(hateMenus)) {
            ExceptionMessages.DUPLICATED_MENUS.throwException();
        }
        if (!isNonHateMenus && isWrongMenus(hateMenus)) {
            ExceptionMessages.NON_EXISTING_MENUS.throwException();
        }
    }

    private boolean isWrongMenus(List<String> hateMenus) {
        boolean wrongMenus = false;
        for (String hateMenu : hateMenus) {
            if (!MenuConstants.isExistingMenu(hateMenu)) {
                wrongMenus = true;
            }
        }
        return wrongMenus;
    }

    private boolean isDuplicated(List<String> hateMenus) {
        return hateMenus.stream()
                .distinct()
                .count() != hateMenus.size();
    }
}
