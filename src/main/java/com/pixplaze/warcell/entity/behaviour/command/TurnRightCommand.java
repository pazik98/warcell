package com.pixplaze.warcell.entity.behaviour.command;

import com.pixplaze.warcell.entity.behaviour.Movable;

public class TurnRightCommand<T extends Movable> implements UnitCommand {

    private final T executor;

    public TurnRightCommand(T executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        executor.turnRight();
    }
}
