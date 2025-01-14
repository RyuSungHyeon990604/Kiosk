package com.kiosk.LV4LV5;

import java.util.HashMap;
import java.util.Map;

public enum MenuCategory {
    BURGER("BURGER",1)
    ,DRINK("DRINK",2)
    ,DESSERT("DESSERT",3)
    ,UNKNOWN("UNKNOWN",-9999);
    private final String label;
    private final int seq;
    private static final Map<Integer, MenuCategory> categoryMap = new HashMap<>();
    MenuCategory(String label, int seq) {
        this.label = label;
        this.seq = seq;
    }
    static {
        for (MenuCategory mc : MenuCategory.values()) {
            if(categoryMap.containsKey(mc.seq)) {
                throw new IllegalArgumentException("Duplicate key: " + mc.seq);
            }
            categoryMap.put(mc.seq, mc);
        }
    }
    public String getLabel() {
        return label;
    }
    public int getSeq() {
        return seq;
    }
    public static MenuCategory getCategory(int choice) {
        if(!categoryMap.containsKey(choice)) {
            return UNKNOWN;
        }
        return categoryMap.get(choice);
    }
}
