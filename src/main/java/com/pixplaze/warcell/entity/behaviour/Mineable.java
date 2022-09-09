package com.pixplaze.warcell.entity.behaviour;

import com.pixplaze.warcell.inventory.ItemStack;
import com.pixplaze.warcell.inventory.ItemType;

public interface Mineable {

    ItemStack gain(int count);

    ItemType getType();
}
