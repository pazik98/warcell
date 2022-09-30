package com.pixplaze.warcell.entity.behaviour.command;

import com.pixplaze.warcell.entity.behaviour.Movable;

public class TurnRightCommand implements UnitCommand {

    @Override
    public void execute(Object o) {
        if (o instanceof Movable) {
            ((Movable) o).turnRight();
        }
    }
}
