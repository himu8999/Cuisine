package com.tiffinocuisine.cuisine.DTOs;

import lombok.Data;

@Data
public class MealDTO {
    private Long mealId;
    private String name;
    private String description;
    private double price;
    private String nutritionInfo;
    private String allergens;
    private Long cuisineId;  // Reference to Cuisine
}
