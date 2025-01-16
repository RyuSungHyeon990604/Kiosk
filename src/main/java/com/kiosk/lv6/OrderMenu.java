package com.kiosk.lv6;

public enum OrderMenu {
    Order(1,"Order","장바구니를 확인 후 주문합니다."),
    Cancel(2,"Cancel","진행중인 주문을 취소합니다."),
    Remove(3,"Remove","장바구니에 담긴 메뉴를 삭제합니다.");
    private final int id;
    private final String name;
    private final String description;
    private OrderMenu(int id,String name, String description) {
        this.id = FoodType.values().length+id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
