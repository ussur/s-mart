package ru.vsu.cs.smart.processing;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemAdapter {
    public List<Item> compose(List<List<Item>> unsortedItems) {
        return unsortedItems.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Item> convert(List<? extends Item> items) {
        List<Item> convertedItems = new ArrayList<>(items.size());
        items.forEach(item -> convertedItems.add(new Item(
                item.getStore(),
                item.getProductUrl(),
                item.getImageUrl(),
                item.getProductName(),
                item.getCategory(),
                item.getPrice(),
                item.getRating()
        )));
        return convertedItems;
    }
}
