package com.kiosk.lv6;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<MenuItem> cartList = new ArrayList<>();
    public void addCart(MenuItem item) {
        cartList.add(item);
    }

    public void removeCart(MenuItem item) {
        cartList.remove(item);
    }

    public List<MenuItem> getCartList() {
        return cartList;
    }

    public boolean isEmpty(){
        return cartList.isEmpty();
    }

    public void showCart(){
        for (MenuItem item : cartList) {
            System.out.println(item);
        }
    }

    public double getTotalPrice(){
        return cartList.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void clear() {
        cartList.clear();
    }
}
