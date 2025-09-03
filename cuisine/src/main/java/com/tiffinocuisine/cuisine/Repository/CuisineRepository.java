package com.tiffinocuisine.cuisine.Repository;


import com.tiffinocuisine.cuisine.Entities.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    // Custom query example: find by name
    Cuisine findByName(String name);
}