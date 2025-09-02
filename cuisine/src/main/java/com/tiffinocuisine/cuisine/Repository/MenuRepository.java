package com.tiffinocuisine.cuisine.Repository;

import com.tiffinocuisine.cuisine.Entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByKitchenId(Long kitchenId);
    List<Menu> findByDate(String date);
}
