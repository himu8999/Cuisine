package com.tiffinocuisine.cuisine.Services;


import com.tiffinocuisine.cuisine.DTOs.MealDTO;
import com.tiffinocuisine.cuisine.Entities.Cuisine;
import com.tiffinocuisine.cuisine.Entities.Meal;
import com.tiffinocuisine.cuisine.Repository.CuisineRepository;
import com.tiffinocuisine.cuisine.Repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

        @Autowired
        private MealRepository mealRepository;

        @Autowired
        private CuisineRepository cuisineRepository;

        // ✅ Create Meal
        public MealDTO createMeal(MealDTO dto) {
            Cuisine cuisine = cuisineRepository.findById(dto.getCuisineId())
                    .orElseThrow(() -> new RuntimeException("Cuisine not found with id: " + dto.getCuisineId()));

            Meal meal = new Meal();
            meal.setName(dto.getName());
            meal.setDescription(dto.getDescription());
            meal.setPrice(dto.getPrice());
            meal.setNutritionInfo(dto.getNutritionInfo());
            meal.setAllergens(dto.getAllergens());
            meal.setCuisine(cuisine);

            Meal savedMeal = mealRepository.save(meal);

            MealDTO response = new MealDTO();
            response.setMealId(savedMeal.getMealId());
            response.setCuisineId(savedMeal.getCuisine().getCuisineId());
            response.setName(savedMeal.getName());
            response.setDescription(savedMeal.getDescription());
            response.setPrice(savedMeal.getPrice());
            response.setNutritionInfo(savedMeal.getNutritionInfo());
            response.setAllergens(savedMeal.getAllergens());

            return response;
        }

        // ✅ Get All Meals
        public List<MealDTO> getAllMeals() {
            return mealRepository.findAll().stream().map(meal -> {
                MealDTO dto = new MealDTO();
                dto.setMealId(meal.getMealId());
                dto.setCuisineId(meal.getCuisine().getCuisineId());
                dto.setName(meal.getName());
                dto.setDescription(meal.getDescription());
                dto.setPrice(meal.getPrice());
                dto.setNutritionInfo(meal.getNutritionInfo());
                dto.setAllergens(meal.getAllergens());
                return dto;
            }).toList();
        }

        // ✅ Get Meal by ID
        public MealDTO getMealById(Long id) {
            Meal meal = mealRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Meal not found with id: " + id));

            MealDTO dto = new MealDTO();
            dto.setMealId(meal.getMealId());
            dto.setCuisineId(meal.getCuisine().getCuisineId());
            dto.setName(meal.getName());
            dto.setDescription(meal.getDescription());
            dto.setPrice(meal.getPrice());
            dto.setNutritionInfo(meal.getNutritionInfo());
            dto.setAllergens(meal.getAllergens());
            return dto;
        }

        // ✅ Update Meal
        public MealDTO updateMeal(Long id, MealDTO dto) {
            Meal meal = mealRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Meal not found with id: " + id));

            meal.setName(dto.getName());
            meal.setDescription(dto.getDescription());
            meal.setPrice(dto.getPrice());
            meal.setNutritionInfo(dto.getNutritionInfo());
            meal.setAllergens(dto.getAllergens());

            if (dto.getCuisineId() != null && !dto.getCuisineId().equals(meal.getCuisine().getCuisineId())) {
                Cuisine cuisine = cuisineRepository.findById(dto.getCuisineId())
                        .orElseThrow(() -> new RuntimeException("Cuisine not found with id: " + dto.getCuisineId()));
                meal.setCuisine(cuisine);
            }

            Meal updatedMeal = mealRepository.save(meal);

            MealDTO updatedDTO = new MealDTO();
            updatedDTO.setMealId(updatedMeal.getMealId());
            updatedDTO.setCuisineId(updatedMeal.getCuisine().getCuisineId());
            updatedDTO.setName(updatedMeal.getName());
            updatedDTO.setDescription(updatedMeal.getDescription());
            updatedDTO.setPrice(updatedMeal.getPrice());
            updatedDTO.setNutritionInfo(updatedMeal.getNutritionInfo());
            updatedDTO.setAllergens(updatedMeal.getAllergens());

            return updatedDTO;
        }

        // ✅ Delete Meal
        public void deleteMeal(Long id) {
            if (!mealRepository.existsById(id)) {
                throw new RuntimeException("Meal not found with id: " + id);
            }
            mealRepository.deleteById(id);
        }

        // ✅ Get Meals by Cuisine ID
        public List<MealDTO> getMealsByCuisine(Long cuisineId) {
            List<Meal> meals = mealRepository.findByCuisine_CuisineId(cuisineId);

            return meals.stream().map(meal -> {
                MealDTO dto = new MealDTO();
                dto.setMealId(meal.getMealId());
                dto.setCuisineId(meal.getCuisine().getCuisineId());
                dto.setName(meal.getName());
                dto.setDescription(meal.getDescription());
                dto.setPrice(meal.getPrice());
                dto.setNutritionInfo(meal.getNutritionInfo());
                dto.setAllergens(meal.getAllergens());
                return dto;
            }).toList();
        }
    }

