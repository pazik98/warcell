package com.pixplaze.warcell.entity.behaviour.program;

import com.pixplaze.warcell.entity.Unit;
import com.pixplaze.warcell.entity.behaviour.command.UnitCommand;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private String codeText = "";

    public Program() {

    }

    public String getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }

    public List<UnitCommand> compileStart() {
        List<UnitCommand> commands = new ArrayList<>();
        //commands.add();
        return commands;
    }
}
