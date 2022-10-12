package com.pixplaze.warcell.entity.types;

import com.pixplaze.warcell.entity.Entity;
import com.pixplaze.warcell.entity.Unit;
import com.pixplaze.warcell.entity.behaviour.Inventoriable;
import com.pixplaze.warcell.entity.behaviour.Mineable;
import com.pixplaze.warcell.entity.behaviour.Miner;
import com.pixplaze.warcell.entity.behaviour.command.CommandManager;
import com.pixplaze.warcell.entity.behaviour.command.UnitCommand;
import com.pixplaze.warcell.inventory.Inventory;
import com.pixplaze.warcell.inventory.ItemStack;
import com.pixplaze.warcell.inventory.Storage;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.List;

public class SimpleMiner extends Unit implements Miner, Inventoriable {

    private final Storage storage = new Storage(1, "SimpleMiner's storage");
    private int mineCount = 10;

    public SimpleMiner() {
        super("SimpleMiner");

        List<UnitCommand> loopList = new ArrayList<>();
        loopList.add(CommandManager.getInstance().get("Turn Right"));
        loopList.add(CommandManager.getInstance().get("Mine"));
        getProgramHandler().setLoopList(loopList);
    }

    @Override
    public void mine() {
        Entity entity = checkFront();
        if (entity instanceof Mineable) {
            Mineable resource = (Mineable) entity;
            if (!getInventory().isFull()) {
                ItemStack item = resource.gain(mineCount);
                getInventory().add(item);
            }
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
