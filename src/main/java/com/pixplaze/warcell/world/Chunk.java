package com.pixplaze.warcell.world;

/**
 * The class responsible for storing and updating cells.
 */
public class Chunk implements IChunk {

    private final ChunkPosition chunkPosition;
    private final Cell[][] cells;

    public Chunk(ChunkPosition chunkPosition) {
        this.chunkPosition = chunkPosition;
        this.cells = new Cell[IChunk.CHUNK_SIZE][IChunk.CHUNK_SIZE];
    }

    @Override
    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    @Override
    public void setCell(Cell cell, int x, int y) {
        cells[x][y] = cell;
    }

    @Override
    public ChunkPosition getChunkPosition() {
        return chunkPosition;
    }

    @Override
    public Chunk clone() throws CloneNotSupportedException {
        return (Chunk) super.clone();
    }

    @Override
    public void update() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j].update();
            }
        }
    }



}
