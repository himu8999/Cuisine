package com.tiffinocuisine.cuisine.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cuisines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuisineId;
    private String name;
    private String description;

    // Custom constructor for DTO mapping
    public Cuisine(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
