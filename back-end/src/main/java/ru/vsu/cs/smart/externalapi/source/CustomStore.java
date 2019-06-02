package ru.vsu.cs.smart.externalapi.source;

import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;
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
                "book 1",
                "books",
                500,
                (byte) 4
        ));
        items.add(new CustomItem(
                null,
                null,
                "scarf 1",
                "clothing",
                1200,
                (byte) 5
        ));
        items.add(new CustomItem(
                null,
                null,
                "book 2",
                "books",
                700,
                (byte) 5
        ));
        items.add(new CustomItem(
                null,
                null,
                "book 3",
                "books",
                600,
                (byte) 3
        ));
        items.add(new CustomItem(
                null,
                null,
                "blouse 1",
                "clothing",
                1000,
                (byte) 1
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
                   String category,
                   Integer price,
                   Byte rating) {
            super("Custom Store", productUrl, imageUrl, productName, category, price, rating);
        }
    }
}
