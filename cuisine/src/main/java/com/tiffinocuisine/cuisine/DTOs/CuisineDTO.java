package com.tiffinocuisine.cuisine.DTOs;

import lombok.Data;

@Data
public class CuisineDTO {
    private Long cuisineId;
    private String name;
    private String description;
}