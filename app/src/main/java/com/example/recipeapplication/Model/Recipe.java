package com.example.recipeapplication.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe_data_table8")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String way_of_prep;
    private String products;
    private String type;
    private int image;

    public Recipe(String title, String way_of_prep, String products,String type, int image) {
        this.title = title;
        this.way_of_prep=way_of_prep;
        this.products = products;
        this.type=type;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWay_of_prep() {
        return way_of_prep;
    }

    public String getProducts() {
        return products;
    }

    public int getImage() {
        return image;
    }
}

