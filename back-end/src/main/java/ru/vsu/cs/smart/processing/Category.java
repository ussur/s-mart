package ru.vsu.cs.smart.processing;

import java.util.HashSet;
import java.util.Set;

public enum Category {
    CLOTHING ("clothing"),
    BOOKS ("books"),
    MEDIA ("media"),
    COMPUTERS ("computers"),
    PHONES ("phones"),
    HOUSE ("house"),
    KIDS ("kids"),
    ACCESSORIES ("accessories"),
    ELECTRONICS ("electronics");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public boolean isEqualTo(String str) {
        if (str == null)
            return false;
        return name.toLowerCase().equals(str.toLowerCase());
    }

    public static Set<String> asStringSet() {
        Set<String> strings = new HashSet<>();
        for (Category c : values()) {
            strings.add(c.name);
        }
        return strings;
    }
}
