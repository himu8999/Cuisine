package com.tiffinocuisine.cuisine.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "meals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long mealId;

    @Column(nullable = false)
    private String name;

    private String description;

    private double price;

    private String nutritionInfo;

    private String allergens;

    @ManyToOne
    @JoinColumn(name = "cuisine_id", nullable = false)
    private Cuisine cuisine;

    @ManyToMany(mappedBy = "meals")
    private List<Menu> menus;
}
