package com.tiffinocuisine.cuisine.Controller;


import com.tiffinocuisine.cuisine.DTOs.MenuDTO;
import com.tiffinocuisine.cuisine.Services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

        @Autowired
        private MenuService menuService;

        // ✅ Create Menu
        @PostMapping
        public MenuDTO createMenu(@RequestBody MenuDTO dto) {
            return menuService.createMenu(dto);
        }

        // ✅ Get All Menus
        @GetMapping
        public List<MenuDTO> getAllMenus() {
            return menuService.getAllMenus();
        }

        // ✅ Get Menu by ID
        @GetMapping("/{id}")
        public MenuDTO getMenuById(@PathVariable Long id) {
            return menuService.getMenuById(id);
        }

        // ✅ Update Menu
        @PutMapping("/{id}")
        public MenuDTO updateMenu(@PathVariable Long id, @RequestBody MenuDTO dto) {
            return menuService.updateMenu(id, dto);
        }

        // ✅ Delete Menu
        @DeleteMapping("/{id}")
        public void deleteMenu(@PathVariable Long id) {
            menuService.deleteMenu(id);
        }

        // ✅ Get Menus by Kitchen ID
        @GetMapping("/kitchen/{kitchenId}")
        public List<MenuDTO> getMenusByKitchen(@PathVariable Long kitchenId) {
            return menuService.getMenusByKitchen(kitchenId);
        }

}
