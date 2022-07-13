package com.pixplaze.warcell.entity.behaviour;

public class MoveCommand<T extends IMovable> implements IUnitCommand {

    private final T executor;

    public MoveCommand(T executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        executor.move();
    }
}
