package ru.vsu.cs.smart.processing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String store;
    private String productUrl;
    private String imageUrl;
    private String productName;
    private Category category;
    private Integer price;
    private Byte rating;
}
