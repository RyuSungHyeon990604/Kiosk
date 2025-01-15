package com.kiosk.lv6;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> menus = new ArrayList<>();

    public List<MenuItem> getMenuList(FoodType category) {
        if(category == null) return new ArrayList<>(0);
        return menus.stream().filter(a->a.getCategory() == category).toList();
    }

    public void loadData() {
        addMenu(FoodType.BURGER,"ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        addMenu(FoodType.BURGER,"SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        addMenu(FoodType.BURGER,"Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        addMenu(FoodType.BURGER,"Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거");
        addMenu(FoodType.DRINK,"콜라",3.0,"시원한 콜라");
        addMenu(FoodType.DRINK,"콜라",3.0,"따뜻한 콜라");
        addMenu(FoodType.DRINK,"사이다",3.0,"시원한 사이다");
        addMenu(FoodType.DRINK,"사이다",3.0,"따뜻한 사이다");
        addMenu(FoodType.DESSERT,"아이스크림",3.0,"시원한 아이스크림");
        addMenu(FoodType.DESSERT,"아이스크림",3.0,"따뜻한 아이스크림");
        addMenu(FoodType.DESSERT,"감자튀김",3.0,"맛있는 감자튀김");
        addMenu(FoodType.DESSERT,"감자튀김",3.0,"맛없는 감자튀김");
    }

    public void addMenu(FoodType category, String name, double price, String description) {
        try{
            menus.add(new MenuItem(category,name, price, description));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
