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

    public void showCart(){
        int n = 1;
        List<MenuItem> items = new ArrayList<>(cart.keySet());
        items.sort((a,b)->a.getCategory().getId() - b.getCategory().getId());
        for (MenuItem item : items) {
            System.out.println((n++)+". "+item+": "+cart.get(item)+"개");
        }
    }

    public MenuItem removeItem(int i) {
        List<MenuItem> items = new ArrayList<>(cart.keySet());
        items.sort((a,b)->a.getCategory().getId() - b.getCategory().getId());
        int rem = cart.get(items.get(i))-1;
        if(rem <= 0)
            cart.remove(items.get(i));
        else
            cart.put(items.get(i),rem);
        return items.get(i);
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

    public void clear() {
        cart.clear();
    }
}
