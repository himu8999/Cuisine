package com.tiffinocuisine.cuisine.Services;


import com.tiffinocuisine.cuisine.DTOs.CuisineDTO;
import com.tiffinocuisine.cuisine.Entities.Cuisine;
import com.tiffinocuisine.cuisine.Repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuisineService {

    @Autowired
    private CuisineRepository cuisineRepository;

    public CuisineDTO createCuisine(CuisineDTO dto) {
        Cuisine cuisine = new Cuisine();
        cuisine.setName(dto.getName());
        cuisine.setDescription(dto.getDescription());

        Cuisine savedCuisine = cuisineRepository.save(cuisine);

        dto.setCuisineId(savedCuisine.getCuisineId());
        return dto;
    }

    public List<CuisineDTO> getAllCuisines() {
        return cuisineRepository.findAll().stream().map(c -> {
            CuisineDTO dto = new CuisineDTO();
            dto.setCuisineId(c.getCuisineId());
            dto.setName(c.getName());
            dto.setDescription(c.getDescription());
            return dto;
        }).collect(Collectors.toList());
    }

    public CuisineDTO getCuisineById(Long id) {
        Cuisine cuisine = cuisineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuisine not found"));

        CuisineDTO dto = new CuisineDTO();
        dto.setCuisineId(cuisine.getCuisineId());
        dto.setName(cuisine.getName());
        dto.setDescription(cuisine.getDescription());
        return dto;
    }

    public void deleteCuisine(Long id) {
        cuisineRepository.deleteById(id);
    }

    public CuisineDTO updateCuisine(Long id, CuisineDTO dto) {
        // Find the cuisine by ID or throw an exception if not found
        Cuisine cuisine = cuisineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuisine not found with id: " + id));

        // Update fields
        cuisine.setName(dto.getName());
        cuisine.setDescription(dto.getDescription());

        // Save updated entity
        Cuisine updatedCuisine = cuisineRepository.save(cuisine);

        // Convert back to DTO
        CuisineDTO updatedDTO = new CuisineDTO();
        updatedDTO.setCuisineId(updatedCuisine.getCuisineId());
        updatedDTO.setName(updatedCuisine.getName());
        updatedDTO.setDescription(updatedCuisine.getDescription());

        return updatedDTO;
    }

}
