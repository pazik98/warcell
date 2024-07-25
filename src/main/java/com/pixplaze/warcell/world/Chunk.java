package com.pixplaze.warcell.world;

/**
 * The class responsible for storing and updating cells.
 */
public class Chunk implements Cloneable {

    private final ChunkPosition chunkPosition;
    private final Cell[][] cells;

    public Chunk(ChunkPosition chunkPosition) {
        this.chunkPosition = chunkPosition;
        this.cells = new Cell[8][8];
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setCell(Cell cell, int x, int y) {
        cells[x][y] = cell;
    }

    public ChunkPosition getChunkPosition() {
        return chunkPosition;
    }

    @Override
    public Chunk clone() throws CloneNotSupportedException {
        return (Chunk) super.clone();
    }

    public void update() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j].update();
            }
        }
    }



}
