package com.pixplaze.warcell.entity.behaviour;

public class TurnRightCommand<T extends IMovable> implements IUnitCommand {

    private final T executor;

    public TurnRightCommand(T executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        executor.turnRight();
    }
}
