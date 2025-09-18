package org.example.babplus.menu.domain;

public enum MealType {

    BREAKFAST("아침"),
    LUNCH("점심"),
    DINNER("저녁");

    private final String label;

    MealType(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
