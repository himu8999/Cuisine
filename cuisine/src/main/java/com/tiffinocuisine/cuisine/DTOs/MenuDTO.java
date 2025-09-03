package com.tiffinocuisine.cuisine.DTOs;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MenuDTO {
    private Long menuId;
    private Long kitchenId;
    private LocalDate date;
    private Integer availableQty;
    private List<Long> mealIds;  // To represent Many-to-Many relationship
}
