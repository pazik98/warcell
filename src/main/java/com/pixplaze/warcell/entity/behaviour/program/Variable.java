package com.pixplaze.warcell.entity.behaviour.program;

public class Variable implements Valuable {

    private Object value;

    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
