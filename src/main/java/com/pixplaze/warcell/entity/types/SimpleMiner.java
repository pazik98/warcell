package com.pixplaze.warcell.entity.types;

import com.pixplaze.warcell.entity.Unit;
import com.pixplaze.warcell.entity.behaviour.Inventoriable;
import com.pixplaze.warcell.entity.behaviour.Mineable;
import com.pixplaze.warcell.entity.behaviour.Miner;
import com.pixplaze.warcell.inventory.Inventory;
import com.pixplaze.warcell.inventory.ItemStack;
import com.pixplaze.warcell.inventory.Storage;

public class SimpleMiner extends Unit implements Miner, Inventoriable {

    private final Storage storage = new Storage(1, "SimpleMiner's storage");
    private int mineCount = 10;

    public SimpleMiner() {
        super("SimpleMiner");
    }

    @Override
    public void mine(Mineable resource) {
        if (!getInventory().isFull()) {
            ItemStack item = resource.gain(mineCount);
            getInventory().add(item);
        }
    }

    @Override
    public Inventory getInventory() {
        return storage;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }
}
