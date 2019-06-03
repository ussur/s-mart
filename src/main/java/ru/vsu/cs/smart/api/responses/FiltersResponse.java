package ru.vsu.cs.smart.api.responses;

import lombok.Data;
import ru.vsu.cs.smart.db.model.Filters;

@Data
public class FiltersResponse {
    private String category;
    private String hint;
    private Integer minPrice;
    private Integer maxPrice;
    private Byte rating;

    public FiltersResponse(Filters filters) {
        category = filters.getCategory();
        hint = filters.getHint();
        minPrice = filters.getMinPrice();
        maxPrice = filters.getMaxPrice();
        rating = filters.getRating();
    }
}
