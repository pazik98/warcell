package com.pixplaze.warcell.world;

public interface IChunk extends Cloneable {
    int CHUNK_SIZE = 8;

    Chunk clone() throws CloneNotSupportedException;

    Cell getCell(int x, int y);

    void setCell(Cell cell, int x, int y);

    ChunkPosition getChunkPosition();

    void update();
}
