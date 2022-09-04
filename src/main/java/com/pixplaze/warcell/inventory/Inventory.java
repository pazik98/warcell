package com.pixplaze.warcell.inventory;

public interface Inventory {

    void add(ItemStack item);

    ItemStack getItem(int cell);

    boolean remove(ItemStack item);

    boolean hasItem(ItemStack item);

    boolean isEmpty();

    boolean isFull();

    String getName();

    int getSize();
}
