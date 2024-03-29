package com.pixplaze.warcell.inventory;

public class Storage implements Inventory {

    private String name;
    private ItemStack[] items;

    public Storage(int size, String name) {
        items = new ItemStack[size];
        for (int i = 0; i < size; i++) {
            items[i] = new ItemStack();
        }
        this.name = name;
    }

    @Override
    public void add(ItemStack item) {
        for (int i = 0; i < items.length; i++) {
            if (item.getCount() > 0) {
                addToSlot(item, i);
            }
        }

        if (item.getCount() > 0 && !isFull()) {
            items[findItemType(ItemType.EMPTY)] = item;
        }
    }

    private void addToSlot(ItemStack item, int slot) {
        ItemStack slotItem = items[slot];

        // Check for identity of types
        if (slotItem.getItemType() != item.getItemType()) {
            return;
        }

        int diff = slotItem.getMaxStack() - slotItem.getCount();
        int count = diff;
        if (item.getCount() < diff) {
            count = item.getCount();
        }

        makeTransaction(item, slotItem, count);
    }

    private void makeTransaction(ItemStack itemFrom, ItemStack itemTo, int count) {
        itemFrom.setCount(itemFrom.getCount() - count);
        itemTo.setCount(itemTo.getCount() + count);
    }

    @Override
    public ItemStack getItem(int slot) {
        return items[slot];
    }

    @Override
    public boolean remove(ItemStack item) {
        if (!hasItem(item)) {
            return false;
        }
        for (ItemStack itemStack : items) {
            if (itemStack.getItemType().equals(item.getItemType())) {
                if (itemStack.getCount() > item.getCount()) {
                    itemStack.setCount(itemStack.getCount() - item.getCount());
                } else if (itemStack.getCount() == item.getCount()) {
                    item = new ItemStack();
                }
            }
        }
        return true;
    }

    @Override
    public boolean hasItem(ItemStack item) {
        for (ItemStack itemStack : items) {
            if (itemStack.getItemType().equals(item.getItemType()) && itemStack.getCount() >= item.getCount()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack item : items) {
            if (!item.getItemType().equals(ItemType.EMPTY)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isFull() {
        for (ItemStack item : items) {
            if (item.getItemType().equals(ItemType.EMPTY) || item.getCount() < item.getMaxStack()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return items.length;
    }

    private int findItemType(ItemType itemType) {
        int cell = 0;
        for (ItemStack item : items) {
            if (item.getItemType() == itemType) {
                return cell;
            } else {
                cell++;
            }
        }
        return -1;
    }
}
