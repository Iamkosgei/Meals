package com.iamkosgei.androidacc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal {
    @SerializedName("strMeal")
    @Expose
    private String name;
    @Expose
    @SerializedName("strMealThumb")
    private String image;

    public Meal() {
    }
    public Meal(String name, String image) {
        this.name = name;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
