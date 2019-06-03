package com.example.s_mart;

public class DataSearch {

    String name;
    String price;
    String category;
    String rating;

    public DataSearch(String name, String price, String category, String rating)
    {
        this.name = name;
        this.price = price;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {

        return name;
    }

    public String getPrice() {

        return price;
    }

    public String getCategory() {

        return category;
    }

    public String getRating() {

        return rating;
    }
}
