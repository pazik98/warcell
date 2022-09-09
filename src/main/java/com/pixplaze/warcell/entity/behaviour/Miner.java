package com.pixplaze.warcell.entity.behaviour;

import com.pixplaze.warcell.inventory.Inventory;

public interface Miner {

    void mine(Mineable resource);

    Inventory getInventory();
}
