package com.pixplaze.warcell.entity.behaviour;

public class TurnLeftCommand<T extends Movable> implements UnitCommand {

    private final T executor;

    public TurnLeftCommand(T executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        executor.turnLeft();
    }
}
