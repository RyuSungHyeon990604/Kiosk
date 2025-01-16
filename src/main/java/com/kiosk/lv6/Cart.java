package com.kiosk.lv6;

import java.util.*;

public class Cart {
    private final Map<MenuItem,Integer> cart = new HashMap<>();
    public void addItem(MenuItem item) {
        cart.put(item,cart.getOrDefault(item,0)+1);
    }

    public boolean isEmpty(){
        return cart.isEmpty();
    }

    public void showCart(){
        for (MenuItem item : cart.keySet()) {
            System.out.println(item+": "+cart.get(item)+"개");
        }
    }

    public void removeItem(MenuItem item) {
        int rem = cart.get(item)-1;
        if(rem <= 0)
            cart.remove(item);
        else
            cart.put(item,rem);
    }

    public int getQuantity(MenuItem item){
        return cart.getOrDefault(item,0);
    }

    public double getTotalPrice(){
        return cart.keySet().stream().mapToDouble(x->x.getPrice()*cart.get(x)).sum();
    }

    public void clear() {
        cart.clear();
    }
}
