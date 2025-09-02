package com.tiffinocuisine.cuisine.Repository;

import com.tiffinocuisine.cuisine.Entities.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepository extends JpaRepository <Cuisine, Long> {
}
