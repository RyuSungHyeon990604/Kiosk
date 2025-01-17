package com.kiosk.lv6;

import java.util.*;

public class Cart {
    //[menu : quantity]
    private final Map<MenuItem, Integer> cart = new HashMap<>();

    public void addItem(MenuItem item) {
        cart.put(item, cart.getOrDefault(item, 0) + 1);
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public MenuItem removeItem(MenuItem item) {
        cart.remove(item);
        return item;
    }

    public int getQuantity(MenuItem item) {
        return cart.getOrDefault(item, 0);
    }

    public double getTotalPrice() {
        return cart.keySet().stream().mapToDouble(x -> x.getPrice() * cart.get(x)).sum();
    }

    public int getSize() {
        return cart.size();
    }

    public List<MenuItem> getItems() {
        return cart.keySet().stream()
                .sorted(Comparator.comparingInt(item -> item.getCategory().getShowSeq()))
                .toList();
    }

    public void clear() {
        cart.clear();
    }
}
