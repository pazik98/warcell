package com.pixplaze.warcell.entity.behaviour.command;

import com.pixplaze.warcell.entity.behaviour.Movable;

public class MoveCommand<T extends Movable> implements UnitCommand {

    private final T executor;

    public MoveCommand(T executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        executor.move();
    }
}
