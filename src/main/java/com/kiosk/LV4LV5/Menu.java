package com.kiosk.LV4LV5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> burgers = new ArrayList<>();
    private final List<MenuItem> drinks = new ArrayList<>();
    private final List<MenuItem> deserts = new ArrayList<>();

    public List<MenuItem> getMenu(MenuCategory category) {
        switch (category) {
            case BURGER -> {
                return burgers;
            }
            case DRINK -> {
                return drinks;
            }
            case DESSERT -> {
                return deserts;
            }
            default -> {
                throw new RuntimeException("카테고리에맞는 메뉴를 찾을 수 없습니다.");
            }
        }
    }

    //
    public void loadData() {
        addMenu(MenuCategory.BURGER,"ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        addMenu(MenuCategory.BURGER,"SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        addMenu(MenuCategory.BURGER,"Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        addMenu(MenuCategory.BURGER,"Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");
        addMenu(MenuCategory.DRINK,"콜라",3.0,"시원한 콜라");
        addMenu(MenuCategory.DRINK,"콜라",3.0,"따뜻한 콜라");
        addMenu(MenuCategory.DRINK,"사이다",3.0,"시원한 사이다");
        addMenu(MenuCategory.DRINK,"사이다",3.0,"따뜻한 사이다");
        addMenu(MenuCategory.DESSERT,"아이스크림",3.0,"시원한 아이스크림");
        addMenu(MenuCategory.DESSERT,"아이스크림",3.0,"따뜻한 아이스크림");
        addMenu(MenuCategory.DESSERT,"감자튀김",3.0,"맛있는 감자튀김");
        addMenu(MenuCategory.DESSERT,"감자튀김",3.0,"맛없는 감자튀김");
    }

    public void addMenu(MenuCategory category, String name, double price, String description) {
        try{
            getMenu(category).add(new MenuItem(name, price, description));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
