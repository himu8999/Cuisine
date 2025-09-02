package com.tiffinocuisine.cuisine.DTOs;

public class MealDTO {

    private Long mealId;
    private String name;
    private Double price;
    private String description;
    private Long cuisineId; // For mapping back to cuisine

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Long cuisineId) {
        this.cuisineId = cuisineId;
    }

    public MealDTO(Long mealId, Long cuisineId, String name, String description, Double price, String nutritionInfo, String allergens) {
        this.mealId = mealId;
        this.cuisineId = cuisineId;
        this.name = name;
        this.description = description;
        this.price = price;
      //  this.nutritionInfo = nutritionInfo;
      //  this.allergens = allergens;
    }


}
