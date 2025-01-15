package com.kiosk.lv6;

public enum DiscountType {
    GENERAL("일반인",0),
    STUDENT("학생",3),
    ARMY("군인",5),
    PATRIOT("국가 유공자",10);
    private final String label;
    private final int discountRate;
    DiscountType(String label,  int discountRate) {
        this.label = label;
        this.discountRate = discountRate;
    }
    public int getDiscountRate() {
        return discountRate;
    }
    public String getLabel() {
        return label;
    }
    public double applyDiscount(double beforePrice) {
        return beforePrice * ((double) (100 - discountRate) / 100);
    }
}
