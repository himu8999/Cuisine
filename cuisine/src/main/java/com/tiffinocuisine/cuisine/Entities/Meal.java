package com.tiffinocuisine.cuisine.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meal {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long mealId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "cuisine_id", nullable = false)
        private Cuisine cuisine;

        @Column(nullable = false)
        private String name;

        private String description;

        @Column(nullable = false)
        private Double price;

        private String nutritionInfo;

        private String allergens;



}
