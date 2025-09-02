package com.tiffinocuisine.cuisine.DTOs;

public class MenuDTO {
    private Long id;
    private String menuName;
    private String menuDescription;
    private String date;
    private Long kitchenId;

    // ✅ Default constructor
    public MenuDTO() {
    }

    // ✅ Parameterized constructor
    public MenuDTO(Long id, String menuName, String menuDescription, String date, Long kitchenId) {
        this.id = id;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.date = date;
        this.kitchenId = kitchenId;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(Long kitchenId) {
        this.kitchenId = kitchenId;
    }
}
