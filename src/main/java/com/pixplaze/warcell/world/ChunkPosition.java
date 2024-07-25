package com.pixplaze.warcell.world;

import com.pixplaze.warcell.exception.OutOfMaxChunkPositionValue;

/**
 * The class is responsible for storing chunk position data.
 * Also, can be used as chunk key pair.
 */
public class ChunkPosition {

    public final int MAX_CHUNK_POSITION_VALUE = 32 * 1024;

    private final int x;
    private final int y;

    public ChunkPosition(int x, int y) {
        try {
            checkChunkPositionValues(x, y);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return x + y * MAX_CHUNK_POSITION_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        ChunkPosition chunkPosition = (ChunkPosition) o;
        return (this.x == chunkPosition.x) && (this.y == chunkPosition.y);
    }

    private void checkChunkPositionValues(int x, int y) throws OutOfMaxChunkPositionValue {
        if (x > MAX_CHUNK_POSITION_VALUE) {
            throw new OutOfMaxChunkPositionValue("Chunk position X is too big! It can't be more than " +
                    MAX_CHUNK_POSITION_VALUE);
        }
        if (y > MAX_CHUNK_POSITION_VALUE) {
            throw new OutOfMaxChunkPositionValue("Chunk position Y is too big! It can't be more than " +
                    MAX_CHUNK_POSITION_VALUE);
        }
    }
}
