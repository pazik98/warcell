package com.pixplaze.warcell.entity.behaviour.program;

public class Compilator {

    public Block compile(Program program) {
        Block mainBlock = new Block();

        Block currentBlock = mainBlock;
        String[] words = program.getCodeText().split(" ");
        for (String word : words) {
            switch (word) {
                case("{") -> {
                    Block childBlock = new Block();
                    currentBlock.addContent(childBlock);
                    currentBlock = childBlock;
                }

                case("}") -> {
                    currentBlock = currentBlock.getParentBlock();
                }

                default -> {
                    // //
                }
            }
        }

        return new Block();
    }
}
