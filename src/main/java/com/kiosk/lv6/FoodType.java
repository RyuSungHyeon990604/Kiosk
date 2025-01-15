package com.kiosk.lv6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum FoodType {
    DRINK("DRINK",2),
    BURGER("BURGER",1),
    DESSERT("DESSERT",3),
    S("S",4);
    private final String label;
    private final int id;
    private static final Map<Integer, FoodType> foodTypeMap = new HashMap<>();
    FoodType(String label, int id) {
        this.label = label;
        this.id = id;
    }
    static {
        for (FoodType mc : FoodType.values()) {
            if(foodTypeMap.containsKey(mc.id)) {
                throw new IllegalArgumentException("Duplicate key: " + mc.id);
            }
            foodTypeMap.put(mc.id, mc);
        }
    }
    public String getLabel() {
        return label;
    }
    public int getId() {
        return id;
    }
    public static FoodType getCategory(int choice) {
        if(!foodTypeMap.containsKey(choice)) {
            return null;
        }
        return foodTypeMap.get(choice);
    }
    public static FoodType[] getAll() {
        FoodType[] values = values();
        Arrays.sort(values, (a,b) -> a.id - b.id);
        return values;
    }
}
