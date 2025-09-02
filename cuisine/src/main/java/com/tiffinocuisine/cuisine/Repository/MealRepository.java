package com.tiffinocuisine.cuisine.Repository;

import com.tiffinocuisine.cuisine.Entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByCuisineCuisineId(Long cuisineId);
}
