package com.pixplaze.warcell.entity.behaviour.program;

public interface ProgramPart {

    void execute();

    Block getParentBlock();

    void setParentBlock(Block block);
}
