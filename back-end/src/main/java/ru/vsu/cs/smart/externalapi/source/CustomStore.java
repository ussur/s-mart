package ru.vsu.cs.smart.externalapi.source;

import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;
import ru.vsu.cs.smart.processing.Category;
import ru.vsu.cs.smart.processing.Item;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomStore {
    private final List<CustomItem> items;

    public CustomStore() {
        items = new ArrayList<>();
        items.add(new CustomItem(
                null,
                null,
                "The Pragmatic Programmer",
                Category.BOOKS,
                1300,
                (byte) 5
        ));
        items.add(new CustomItem(
                null,
                null,
                "Джинсы",
                Category.CLOTHING,
                2200,
                (byte) 5
        ));
        items.add(new CustomItem(
                null,
                null,
                "Java Concurrency in Practice",
                Category.BOOKS,
                700,
                (byte) 5
        ));
        items.add(new CustomItem(
                null,
                null,
                "Design Patterns Elements of Reusable Object-Oriented Software",
                Category.BOOKS,
                800,
                (byte) 5
        ));
        items.add(new CustomItem(
                null,
                null,
                "Кардиган",
                Category.CLOTHING,
                1000,
                (byte) 1
        ));
        items.add(new CustomItem(
                null,
                null,
                "Бинокль BRADEX DE",
                Category.KIDS,
                327,
                null
        ));
        items.add(new CustomItem(
                null,
                null,
                "Конструктор LEGO Technic",
                Category.KIDS,
                950,
                (byte) 4
        ));
        items.add(new CustomItem(
                null,
                null,
                "HUAWEI Nova 2",
                Category.PHONES,
                33000,
                (byte) 5
        ));
        items.add(new CustomItem(
                null,
                null,
                "Apple iPhone 7",
                Category.PHONES,
                35990,
                (byte) 3
        ));
        items.add(new CustomItem(
                null,
                null,
                "Samsung Galaxy S10 8",
                Category.PHONES,
                48315,
                (byte) 4
        ));
    }

    public List<? extends Item> getItems() {
        return items;
    }

    @EqualsAndHashCode(callSuper = true)
    private class CustomItem extends Item {
        CustomItem(String productUrl,
                   String imageUrl,
                   String productName,
                   Category category,
                   Integer price,
                   Byte rating) {
            super("Custom Store", productUrl, imageUrl, productName, category, price, rating);
        }
    }
}
