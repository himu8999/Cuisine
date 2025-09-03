package com.tiffinocuisine.cuisine.Controller;


import com.tiffinocuisine.cuisine.DTOs.MealDTO;
import com.tiffinocuisine.cuisine.Services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

        @Autowired
        private MealService mealService;

        // ✅ Create Meal
        @PostMapping
        public MealDTO createMeal(@RequestBody MealDTO dto) {
            return mealService.createMeal(dto);
        }

        // ✅ Get All Meals
        @GetMapping
        public List<MealDTO> getAllMeals() {
            return mealService.getAllMeals();
        }

        // ✅ Get Meal by ID
        @GetMapping("/{id}")
        public MealDTO getMealById(@PathVariable Long id) {
            return mealService.getMealById(id);
        }

        // ✅ Update Meal
        @PutMapping("/{id}")
        public MealDTO updateMeal(@PathVariable Long id, @RequestBody MealDTO dto) {
            return mealService.updateMeal(id, dto);
        }

        // ✅ Delete Meal
        @DeleteMapping("/{id}")
        public void deleteMeal(@PathVariable Long id) {
            mealService.deleteMeal(id);
        }

        // ✅ Get Meals by Cuisine ID
        @GetMapping("/cuisine/{cuisineId}")
        public List<MealDTO> getMealsByCuisine(@PathVariable Long cuisineId) {
            return mealService.getMealsByCuisine(cuisineId);
        }

}
