package ru.vsu.cs.smart.processing;

public enum Category {
    CLOTHING ("clothing"),
    BOOKS ("books"),
    MEDIA ("media"),
    COMPUTERS ("computers"),
    PHONES ("phones"),
    HOUSE ("house"),
    KIDS ("kids"),
    ACCESSORIES ("accessories");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public boolean isEqualTo(String str) {
        if (str == null)
            return false;
        return name.toLowerCase().equals(str.toLowerCase());
    }
}
