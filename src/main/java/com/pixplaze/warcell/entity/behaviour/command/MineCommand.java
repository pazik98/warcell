package com.pixplaze.warcell.entity.behaviour.command;

import com.pixplaze.warcell.entity.behaviour.Miner;

public class MineCommand<T extends Miner> implements UnitCommand {

    private final T executor;

    public MineCommand(T executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        executor.mine();
    }
}
