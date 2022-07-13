package com.pixplaze.warcell.entity.behaviour;

public class TurnLeftCommand<T extends IMovable> implements IUnitCommand {

    private final T executor;

    public TurnLeftCommand(T executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        executor.turnLeft();
    }
}
