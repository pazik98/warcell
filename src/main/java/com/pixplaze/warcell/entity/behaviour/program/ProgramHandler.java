package com.pixplaze.warcell.entity.behaviour.program;

import com.pixplaze.warcell.entity.behaviour.Programmable;
import com.pixplaze.warcell.entity.behaviour.command.CommandManager;
import com.pixplaze.warcell.entity.behaviour.command.UnitCommand;

import java.util.ArrayList;
import java.util.List;

public class ProgramHandler {

    protected CommandManager commandManager = CommandManager.getInstance();
    private Program actualProgram;
    private Programmable entity;
    private boolean isPaused = false;
    private List<UnitCommand> startList = new ArrayList<>();
    private List<UnitCommand> loopList = new ArrayList<>();

    private int counter = 0;

    public ProgramHandler() {
        loopList.add(commandManager.get("Turn Right"));
        loopList.add(commandManager.get("Move"));
    }

    public void setLoopList(List<UnitCommand> commandList) {
        loopList = commandList;
    }

    public Program getActualProgram() {
        return actualProgram;
    }

    public void setActualProgram(Program program) {
        this.actualProgram = program;
    }

    public Programmable getEntity() {
        return entity;
    }

    public void setEntity(Programmable entity) {
        this.entity = entity;
    }

    public UnitCommand getNextCommand() {
        UnitCommand command = loopList.get(counter++);
        if (counter > loopList.size() - 1) {
            counter = 0;
        }
        return command;
    }
}
