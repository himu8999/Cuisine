package com.tiffinocuisine.cuisine.Repository;

import com.tiffinocuisine.cuisine.Entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // Fetch menus by date
    List<Menu> findByDate(LocalDate date);

    // Fetch menus by kitchenId
    List<Menu> findByKitchenId(Long kitchenId);
}