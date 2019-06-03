package ru.vsu.cs.smart.api.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vsu.cs.smart.db.model.Filters;
import ru.vsu.cs.smart.db.model.User;

@Data
@NoArgsConstructor
public class FiltersData {
    private String category;
    private String hint;
    private Integer minPrice;
    private Integer maxPrice;
    private Byte rating;
    private Long userId;

    public FiltersData(Filters filters) {
        category = filters.getCategory();
        hint = filters.getHint();
        minPrice = filters.getMinPrice();
        maxPrice = filters.getMaxPrice();
        rating = filters.getRating();
        userId = filters.getUser().getId();
    }

    public Filters toFilters() {
        Filters filters =  new Filters();
        filters.setCategory(category);
        filters.setHint(hint);
        filters.setMinPrice(minPrice);
        filters.setMaxPrice(maxPrice);
        filters.setRating(rating);

        User user = new User();
        user.setId(userId);
        filters.setUser(user);

        return filters;
    }
}
