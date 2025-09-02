package com.tiffinocuisine.cuisine.Services;

import com.tiffinocuisine.cuisine.DTOs.CuisineDTO;
import com.tiffinocuisine.cuisine.Entities.Cuisine;
import com.tiffinocuisine.cuisine.Repository.CuisineRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CuisineService {

    private final CuisineRepository cuisineRepository;

    public CuisineService(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }

    public CuisineDTO createCuisine(CuisineDTO dto) {
        Cuisine cuisine = new Cuisine(dto.getName(), dto.getDescription());
        Cuisine savedCuisine = cuisineRepository.save(cuisine);
        return new CuisineDTO(savedCuisine.getCuisineId(), savedCuisine.getName(), savedCuisine.getDescription());
    }

    public List<CuisineDTO> getAllCuisines() {
        return cuisineRepository.findAll()
                .stream()
                .map(c -> new CuisineDTO(c.getCuisineId(), c.getName(), c.getDescription()))
                .collect(Collectors.toList());
    }

    public CuisineDTO getCuisineById(Long id) {
        Cuisine cuisine = cuisineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuisine not found"));
        return new CuisineDTO(cuisine.getCuisineId(), cuisine.getName(), cuisine.getDescription());
    }

    public CuisineDTO updateCuisine(Long id, CuisineDTO dto) {
        Cuisine cuisine = cuisineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuisine not found"));
        cuisine.setName(dto.getName());
        cuisine.setDescription(dto.getDescription());
        Cuisine updated = cuisineRepository.save(cuisine);
        return new CuisineDTO(updated.getCuisineId(), updated.getName(), updated.getDescription());
    }

    public void deleteCuisine(Long id) {
        cuisineRepository.deleteById(id);
    }

}
