package com.pixplaze.warcell.entity.behaviour.command;

import com.pixplaze.warcell.entity.Entity;

public interface UnitCommand {

    /**
     * Responsible for generalizing all entity management commands
     */

    void execute(Object o);
}
