package com.pixplaze.warcell.entity.behaviour.program;

import com.pixplaze.warcell.entity.behaviour.Programmable;
import com.pixplaze.warcell.entity.behaviour.command.UnitCommand;

import java.util.LinkedList;
import java.util.List;

public class ProgramExecutor {

    private Program actualProgram;
    private Programmable entity;
    private boolean isPaused = false;
    private List<UnitCommand> startList = new LinkedList<>();
    private List<UnitCommand> loopList = new LinkedList<>();

    private UnitCommand nextCommand;

    public Program getActualProgram() {
        return actualProgram;
    }

    public void setActualProgram(Program actualProgram) {
        this.actualProgram = actualProgram;
    }

    public Programmable getEntity() {
        return entity;
    }

    public void setEntity(Programmable entity) {
        this.entity = entity;
    }

    public UnitCommand getNextCommand() {

        return null;
    }
}
