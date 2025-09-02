package com.tiffinocuisine.cuisine.DTOs;

import java.util.List;

public class CuisineDTO {

    private Long cuisineId;
    private String name;
    private String description;
    private List<MealDTO> meals;

    public Long getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Long cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MealDTO> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDTO> meals) {
        this.meals = meals;
    }

    public CuisineDTO(Long cuisineId, String name, String description) {
        this.cuisineId = cuisineId;
        this.name = name;
        this.description = description;
    }


}
