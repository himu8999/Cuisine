package com.tiffinocuisine.cuisine.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "menus")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long menuId;

        @Column(nullable = false)
        private Long kitchenId; // assuming kitchen entity exists later

        @Column(nullable = false)
        private LocalDate date;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "meal_id", nullable = false)
        private Meal meal;

        @Column(nullable = false)
        private Integer availableQty;

    public Menu(Long menuId, LocalDate date, Meal meal, Integer availableQty) {
        this.menuId = menuId;

        this.date = date;
        this.meal = meal;
        this.availableQty = availableQty;
    }
}
