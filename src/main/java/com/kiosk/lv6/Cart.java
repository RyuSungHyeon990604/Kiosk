package com.kiosk.lv6;

import java.util.*;

public class Cart {
    //[menu : quantity]
    private final Map<MenuItem,Integer> cart = new HashMap<>();
    public void addItem(MenuItem item) {
        cart.put(item,cart.getOrDefault(item,0)+1);
    }

    public boolean isEmpty(){
        return cart.isEmpty();
    }

    public MenuItem removeItem(MenuItem item) {
        cart.remove(item);
        return item;
    }

    public int getQuantity(MenuItem item){
        return cart.getOrDefault(item,0);
    }

    public double getTotalPrice(){
        return cart.keySet().stream().mapToDouble(x->x.getPrice()*cart.get(x)).sum();
    }

    public int getSize(){
        return cart.size();
    }

    public List<MenuItem> getItems(){
        List<MenuItem> items = new ArrayList<>(cart.keySet());
        //우선순위대로 리스트를 반환
        items.sort((a,b)->a.getCategory().getShowSeq() - b.getCategory().getShowSeq());
        return items;
    }

    public void clear() {
        cart.clear();
    }
}
