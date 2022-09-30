package com.pixplaze.warcell.entity.behaviour.command;

import com.pixplaze.warcell.entity.behaviour.Movable;

public class TurnLeftCommand implements UnitCommand {

    @Override
    public void execute(Object o) {
        if (o instanceof Movable) {
            ((Movable) o).turnLeft();
        }
    }
}
