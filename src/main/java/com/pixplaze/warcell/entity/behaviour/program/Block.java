package com.pixplaze.warcell.entity.behaviour.program;

import java.util.List;

public class Block implements ProgramPart {

    private List<ProgramPart> content;
    private Block parentBlock;

    public List<ProgramPart> getContent() {
        return content;
    }

    public void addContent(ProgramPart part) {
        this.content.add(part);
        part.setParentBlock(this);
    }

    public Block getParentBlock() {
        return parentBlock;
    }

    public void setParentBlock(Block block) {
        this.parentBlock = block;
    }

    @Override
    public void execute() {

    }
}
