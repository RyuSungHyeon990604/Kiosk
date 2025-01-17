package com.kiosk.lv6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum FoodType {
    DRINK("DRINK", 2, 2),
    BURGER("BURGER", 1, 1),
    DESSERT("DESSERT", 3, 3),
    EVENT("EVENT", 4, 0);
    private final String label;
    private final int id;
    private final int showSeq;
//    private static final Map<Integer, FoodType> foodTypeMap = new HashMap<>();

    FoodType(String label, int id, int showSeq) {
        this.label = label;
        this.id = id;
        this.showSeq = showSeq;
    }

//    static {
//        for (FoodType mc : FoodType.values()) {
//            if (foodTypeMap.containsKey(mc.id)) {
//                throw new IllegalArgumentException("Duplicate key: " + mc.id);
//            }
//            foodTypeMap.put(mc.id, mc);
//        }
//    }

    public String getLabel() {
        return label;
    }

    public int getId() {
        return id;
    }

    public int getShowSeq() {
        return showSeq;
    }

    public static FoodType getCategory(int choice) {
        for (FoodType type : values()) {
            if(type.id == choice)
                return type;
        }
        return null;
    }

    public static FoodType[] getAll() {
        return Arrays.stream(values())
                .filter(a -> a.showSeq > 0)
                .sorted((a, b) -> a.getId() - b.getId())
                .toArray(FoodType[]::new);
    }
}
