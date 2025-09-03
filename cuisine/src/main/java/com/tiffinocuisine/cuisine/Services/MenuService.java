package com.tiffinocuisine.cuisine.Services;


import com.tiffinocuisine.cuisine.DTOs.MenuDTO;
import com.tiffinocuisine.cuisine.Entities.Meal;
import com.tiffinocuisine.cuisine.Entities.Menu;
import com.tiffinocuisine.cuisine.Repository.MealRepository;
import com.tiffinocuisine.cuisine.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MealRepository mealRepository;

    // ✅ Create Menu
    public MenuDTO createMenu(MenuDTO dto) {
        Menu menu = new Menu();
        menu.setDate(dto.getDate());
        menu.setKitchenId(dto.getKitchenId());
        menu.setAvailableQty(dto.getAvailableQty());

        // Fetch meals by IDs and set to menu
        List<Meal> meals = mealRepository.findAllById(dto.getMealIds());
        menu.setMeals(meals);

        Menu savedMenu = menuRepository.save(menu);

        MenuDTO response = new MenuDTO();
        response.setMenuId(savedMenu.getMenuId());
        response.setDate(savedMenu.getDate());
        response.setKitchenId(savedMenu.getKitchenId());
        response.setAvailableQty(savedMenu.getAvailableQty());
        response.setMealIds(savedMenu.getMeals().stream().map(Meal::getMealId).toList());

        return response;
    }

    // ✅ Get All Menus
    public List<MenuDTO> getAllMenus() {
        return menuRepository.findAll().stream().map(menu -> {
            MenuDTO dto = new MenuDTO();
            dto.setMenuId(menu.getMenuId());
            dto.setDate(menu.getDate());
            dto.setKitchenId(menu.getKitchenId());
            dto.setAvailableQty(menu.getAvailableQty());
            dto.setMealIds(menu.getMeals().stream().map(Meal::getMealId).toList());
            return dto;
        }).toList();
    }

    // ✅ Get Menu by ID
    public MenuDTO getMenuById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));

        MenuDTO dto = new MenuDTO();
        dto.setMenuId(menu.getMenuId());
        dto.setDate(menu.getDate());
        dto.setKitchenId(menu.getKitchenId());
        dto.setAvailableQty(menu.getAvailableQty());
        dto.setMealIds(menu.getMeals().stream().map(Meal::getMealId).toList());

        return dto;
    }

    // ✅ Update Menu
    public MenuDTO updateMenu(Long id, MenuDTO dto) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));

        menu.setDate(dto.getDate());
        menu.setKitchenId(dto.getKitchenId());
        menu.setAvailableQty(dto.getAvailableQty());

        if (dto.getMealIds() != null && !dto.getMealIds().isEmpty()) {
            List<Meal> meals = mealRepository.findAllById(dto.getMealIds());
            menu.setMeals(meals);
        }

        Menu updatedMenu = menuRepository.save(menu);

        MenuDTO updatedDTO = new MenuDTO();
        updatedDTO.setMenuId(updatedMenu.getMenuId());
        updatedDTO.setDate(updatedMenu.getDate());
        updatedDTO.setKitchenId(updatedMenu.getKitchenId());
        updatedDTO.setAvailableQty(updatedMenu.getAvailableQty());
        updatedDTO.setMealIds(updatedMenu.getMeals().stream().map(Meal::getMealId).toList());

        return updatedDTO;
    }

    // ✅ Delete Menu
    public void deleteMenu(Long id) {
        if (!menuRepository.existsById(id)) {
            throw new RuntimeException("Menu not found with id: " + id);
        }
        menuRepository.deleteById(id);
    }

    // ✅ Get Menus by Kitchen ID
    public List<MenuDTO> getMenusByKitchen(Long kitchenId) {
        List<Menu> menus = menuRepository.findByKitchenId(kitchenId);

        return menus.stream().map(menu -> {
            MenuDTO dto = new MenuDTO();
            dto.setMenuId(menu.getMenuId());
            dto.setDate(menu.getDate());
            dto.setKitchenId(menu.getKitchenId());
            dto.setAvailableQty(menu.getAvailableQty());
            dto.setMealIds(menu.getMeals().stream().map(Meal::getMealId).toList());
            return dto;
        }).toList();
    }
}
