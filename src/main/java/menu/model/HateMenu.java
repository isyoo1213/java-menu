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
        if (hateMenus.isEmpty()) {
            return;
        }
        if (isDuplicated(hateMenus)) {
            ExceptionMessages.DUPLICATED_MENUS.throwException();
        }
        if (isWrongMenus(hateMenus)) {
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
                .count() != this.hateMenus.size();
    }
}
