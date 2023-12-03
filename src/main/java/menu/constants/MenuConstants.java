package menu.constants;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuConstants {
    JAPANESE_FOOD(1, "일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_FOOD(2, "한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_FOOD(3, "중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_FOOD(4, "아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠양꿍", "반미", "월남쌈", "분짜")),
    WESTERN_FOOD(5, "양식", Arrays.asList("라자냐", "그라탕", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private static final List<String> ALL_MENUS =
            Stream.of(JAPANESE_FOOD.menus, KOREAN_FOOD.menus, CHINESE_FOOD.menus, ASIAN_FOOD.menus, WESTERN_FOOD.menus)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
    private static final Map<Integer, MenuConstants> CATEGORY_BY_NUMBER =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(MenuConstants::categoryNumber, Function.identity())));

    private final int categoryNumber;
    private final String categoryName;
    private final List<String> menus;

    MenuConstants(int categoryNumber, String categoryName, List<String> menus) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
        this.menus = menus;
    }

    public static boolean isExistingMenu(String menuName) {
        return ALL_MENUS.contains(menuName);
    }

    private int categoryNumber() {
        return categoryNumber;
    }
}
