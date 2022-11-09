package com.pixplaze.warcell.entity.behaviour.program;

public class Assignment extends Expression {

    private Variable leftSide;
    private Valuable rightSide;

    public Assignment(Program program, Variable leftSide, Valuable rightSide) {
        super(program);
    }

    @Override
    public void execute() {
        leftSide.setValue(rightSide.getValue());
    }
}
