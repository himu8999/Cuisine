package com.tiffinocuisine.cuisine.Controller;


import com.tiffinocuisine.cuisine.DTOs.CuisineDTO;
import com.tiffinocuisine.cuisine.Services.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuisines")
public class CuisineController {


        @Autowired
        private CuisineService cuisineService;

        // ✅ Create Cuisine
        @PostMapping
        public CuisineDTO createCuisine(@RequestBody CuisineDTO dto) {
            return cuisineService.createCuisine(dto);
        }

        // ✅ Get All Cuisines
        @GetMapping
        public List<CuisineDTO> getAllCuisines() {
            return cuisineService.getAllCuisines();
        }

        // ✅ Get Cuisine by ID
        @GetMapping("/{id}")
        public CuisineDTO getCuisineById(@PathVariable Long id) {
            return cuisineService.getCuisineById(id);
        }

        // ✅ Update Cuisine
        @PutMapping("/{id}")
        public CuisineDTO updateCuisine(@PathVariable Long id, @RequestBody CuisineDTO dto) {
            return cuisineService.updateCuisine(id, dto);
        }

        // ✅ Delete Cuisine
        @DeleteMapping("/{id}")
        public void deleteCuisine(@PathVariable Long id) {
            cuisineService.deleteCuisine(id);
        }
    }
