package com.tiffinocuisine.cuisine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cuisines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuisine_id")
    private Long cuisineId;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Meal> meals;
}
