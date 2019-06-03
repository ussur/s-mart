package ru.vsu.cs.smart.api.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vsu.cs.smart.db.model.Favourite;
import ru.vsu.cs.smart.db.model.User;

@Data
@NoArgsConstructor
public class FavouriteData {
    private String store;
    private String productUrl;
    private String imageUrl;
    private String productName;
    private String category;
    private Integer price;
    private Byte rating;
    private Long userId;

    public FavouriteData(Favourite favourite) {
        store = favourite.getStore();
        productUrl = favourite.getProductUrl();
        imageUrl = favourite.getImageUrl();
        productName = favourite.getProductName();
        category = favourite.getCategory();
        price = favourite.getPrice();
        rating = favourite.getRating();
        userId = favourite.getUser().getId();
    }

    public Favourite toFavourite() {
        Favourite favourite =  new Favourite();
        favourite.setStore(store);
        favourite.setProductUrl(productUrl);
        favourite.setImageUrl(imageUrl);
        favourite.setProductName(productName);
        favourite.setCategory(category);
        favourite.setPrice(price);
        favourite.setRating(rating);

        User user = new User();
        user.setId(userId);
        favourite.setUser(user);

        return favourite;
    }
}
