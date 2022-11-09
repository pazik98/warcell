package com.pixplaze.warcell.entity.behaviour.program;

public abstract class Expression implements ProgramPart {

    protected Program program;

    public Expression(Program program) {
        this.program = program;
    }

    @Override
    public void execute() {

    }
}
