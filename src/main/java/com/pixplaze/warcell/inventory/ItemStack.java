package com.pixplaze.warcell.inventory;

public class ItemStack {

    private String name = "Item";
    private int count = 1;
    private int maxStack = 64;
    private boolean stackable = true;
    private ItemType itemType = ItemType.EMPTY;

    public ItemStack() {}

    public ItemStack(String name, int count, ItemType itemType) {
        this.name = name;
        this.count = count;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public boolean isStackable() {
        return stackable;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
