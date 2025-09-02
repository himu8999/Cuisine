package com.tiffinocuisine.cuisine.Services;


import com.tiffinocuisine.cuisine.DTOs.MenuDTO;
import com.tiffinocuisine.cuisine.Entities.Menu;
import com.tiffinocuisine.cuisine.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuService {

        @Autowired
        private MenuRepository menuRepository;

        // ✅ Convert Entity to DTO
        private MenuDTO convertToDTO(Menu menu) {
            MenuDTO dto = new MenuDTO();
            dto.setMenuId(menu.getMenuId());
            dto.setMenuName(menu.getMenuName());
            dto.setDate(menu.getDate());
            dto.setKitchenId(menu.getKitchenId());
            return dto;
        }

        // ✅ Convert DTO to Entity
        private Menu convertToEntity(MenuDTO dto) {
            Menu menu = new Menu();
            menu.setMenuId(dto.getMenuId());
            menu.setMenuName(dto.getMenuName());
            menu.setDate(dto.getDate());
            menu.setKitchenId(dto.getKitchenId());
            return menu;
        }

        // ✅ Get all menus
        public List<MenuDTO> getAllMenus() {
            return menuRepository.findAll().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        // ✅ Get menu by ID
        public MenuDTO getMenuById(Long id) {
            Optional<Menu> menuOpt = menuRepository.findById(id);
            return menuOpt.map(this::convertToDTO).orElse(null);
        }

        // ✅ Get menus by kitchenId
        public List<MenuDTO> getMenusByKitchenId(Long kitchenId) {
            return menuRepository.findByKitchenId(kitchenId).stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        // ✅ Get menus by date
        public List<MenuDTO> getMenusByDate(String date) {
            return menuRepository.findByDate(date).stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        // ✅ Create menu
        public MenuDTO createMenu(MenuDTO dto) {
            Menu menu = convertToEntity(dto);
            Menu savedMenu = menuRepository.save(menu);
            return convertToDTO(savedMenu);
        }

        // ✅ Update menu
        public MenuDTO updateMenu(Long id, MenuDTO dto) {
            Optional<Menu> menuOpt = menuRepository.findById(id);
            if (menuOpt.isPresent()) {
                Menu menu = menuOpt.get();
                menu.setMenuName(dto.getMenuName());
                menu.setDate(dto.getDate());
                menu.setKitchenId(dto.getKitchenId());
                Menu updatedMenu = menuRepository.save(menu);
                return convertToDTO(updatedMenu);
            }
            return null;
        }

        // ✅ Delete menu
        public boolean deleteMenu(Long id) {
            if (menuRepository.existsById(id)) {
                menuRepository.deleteById(id);
                return true;
            }
            return false;
        }
    }


}
