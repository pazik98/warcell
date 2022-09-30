package com.pixplaze.warcell.entity.behaviour.command;

public class CommandResult {

    private Boolean logicValue;
    private Integer intValue;
    private Float floatValue;

    public void setValue(boolean value) {
        logicValue = value;
    }

    public void setValue(int value) {
        intValue = value;
    }

    public void setValue(float value) {
        floatValue = value;
    }

    public Object getValue() {
        if (logicValue != null) return logicValue;
        if (intValue != null) return intValue;
        if (floatValue != null) return floatValue;
        return null;
    }
}
