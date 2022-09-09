package com.pixplaze.warcell.entity;

import com.pixplaze.warcell.entity.behaviour.Mineable;
import com.pixplaze.warcell.inventory.ItemStack;
import com.pixplaze.warcell.inventory.ItemType;

public abstract class Resource extends Entity implements Mineable {

    private ItemStack content;

    public Resource() {
        super();
        setContent(new ItemStack());
    }

    public Resource(String name) {
        super(name);
        setContent(new ItemStack());
    }

    public void setContent(ItemStack itemStack) {
        this.content = itemStack;
    }

    @Override
    public ItemStack gain(int count) {
        if (count < content.getCount()) {
            content.setCount(content.getCount() - count);
            return new ItemStack(count, getType());
        } else {
            int c = content.getCount();
            setContent(new ItemStack());
            return new ItemStack(c, getType());
        }
    }

    @Override
    public ItemType getType() {
        return content.getItemType();
    }
}
