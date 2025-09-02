package com.tiffinocuisine.cuisine.Services;


import com.tiffinocuisine.cuisine.Entities.Meal;
import com.tiffinocuisine.cuisine.Repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

        private final MealRepository mealRepository;

        @Autowired
        public MealService(MealRepository mealRepository) {
            this.mealRepository = mealRepository;
        }

        // Create or Save Meal
        public Meal saveMeal(Meal meal) {
            return mealRepository.save(meal);
        }

        // Get All Meals
        public List<Meal> getAllMeals() {
            return mealRepository.findAll();
        }

        // Get Meal by ID
        public Optional<Meal> getMealById(Long mealId) {
            return mealRepository.findById(mealId);
        }

        // Get Meals by Cuisine ID
        public List<Meal> getMealsByCuisineId(Long cuisineId) {
            return mealRepository.findByCuisineCuisineId(cuisineId);
        }

        // Update Meal
        public Meal updateMeal(Long mealId, Meal updatedMeal) {
            return mealRepository.findById(mealId).map(meal -> {
                meal.setName(updatedMeal.getName());
                meal.setDescription(updatedMeal.getDescription());
                meal.setPrice(updatedMeal.getPrice());
                meal.setNutritionInfo(updatedMeal.getNutritionInfo());
                meal.setAllergens(updatedMeal.getAllergens());
                return mealRepository.save(meal);
            }).orElseThrow(() -> new RuntimeException("Meal not found with id " + mealId));
        }

        // Delete Meal
        public void deleteMeal(Long mealId) {
            if (!mealRepository.existsById(mealId)) {
                throw new RuntimeException("Meal not found with id " + mealId);
            }
            mealRepository.deleteById(mealId);
        }

}
