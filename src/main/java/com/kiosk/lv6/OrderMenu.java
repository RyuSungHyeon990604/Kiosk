package com.kiosk.lv6;

import java.util.Arrays;
import java.util.Comparator;

public enum OrderMenu {
    Order(1, "Order", "장바구니를 확인 후 주문합니다."),
    Cancel(2, "Cancel", "진행중인 주문을 취소합니다."),
    Remove(3, "Remove", "장바구니에 담긴 메뉴를 삭제합니다.");
    private final int id;
    private final String name;
    private final String description;

    OrderMenu(int id, String name, String description) {
        this.id = FoodType.getAll().length + id;
        this.name = name;
        this.description = description;
    }

    public static OrderMenu[] getAll() {
        return Arrays.stream(OrderMenu.values())
                .sorted(Comparator.comparing(a -> a.id))
                .toArray(OrderMenu[]::new);
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
