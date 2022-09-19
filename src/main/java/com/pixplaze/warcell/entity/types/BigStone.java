package com.pixplaze.warcell.entity.types;

import com.pixplaze.warcell.entity.Resource;
import com.pixplaze.warcell.inventory.ItemStack;
import com.pixplaze.warcell.inventory.ItemType;

public class BigStone extends Resource {

    public BigStone() {
        super("Big stone");
        setContent(new ItemStack(500, ItemType.STONE));
    }
}
