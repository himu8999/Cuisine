package com.tiffinocuisine.cuisine.Repository;


import com.tiffinocuisine.cuisine.Entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByCuisine_CuisineId(Long cuisineId);
}