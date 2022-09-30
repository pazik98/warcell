package com.pixplaze.warcell.entity.behaviour.command;

import com.pixplaze.warcell.entity.behaviour.Miner;

public class MineCommand implements UnitCommand {

    @Override
    public void execute(Object o) {
        if (o instanceof Miner) {
            ((Miner) o).mine();
        }
    }
}
