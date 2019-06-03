package com.example.s_mart;

public class DataSearchFilters {

    String name;
    String category;
    String rating;

    public DataSearchFilters(String name, String category, String rating)
    {
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {

        return name;
    }


    public String getCategory() {

        return category;
    }

    public String getRating() {

        return rating;
    }
}
