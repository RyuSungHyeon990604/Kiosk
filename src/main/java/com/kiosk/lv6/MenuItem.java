package com.kiosk.lv6;

public class MenuItem {
    private FoodType category;
    private String name;
    private double price;
    private String description;
    public MenuItem(FoodType category, String name, double price, String description) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public FoodType getCategory() {return this.category;}
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    @Override
    public String toString(){
        return name+" | "+price+" | "+description;
    }
}
