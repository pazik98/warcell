package com.pixplaze.warcell.entity.behaviour.command;

import com.pixplaze.warcell.entity.behaviour.Miner;

public class MineCommand implements UnitCommand {

    @Override
    public CommandResult execute(Object o) {
        if (o instanceof Miner) {
            ((Miner) o).mine();
        }
        return null;
    }
}
