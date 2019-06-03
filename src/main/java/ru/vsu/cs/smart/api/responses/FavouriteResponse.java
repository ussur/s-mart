package ru.vsu.cs.smart.api.responses;

import lombok.Data;
import ru.vsu.cs.smart.db.model.Favourite;

@Data
public class FavouriteResponse {
    private String store;
    private String productUrl;
    private String imageUrl;
    private String productName;
    private String category;
    private Integer price;
    private Byte rating;

    public FavouriteResponse(Favourite favourite) {
        store = favourite.getStore();
        productUrl = favourite.getProductUrl();
        imageUrl = favourite.getImageUrl();
        productName = favourite.getProductName();
        category = favourite.getCategory();
        price = favourite.getPrice();
        rating = favourite.getRating();
    }
}
