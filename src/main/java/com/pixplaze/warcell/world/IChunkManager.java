package com.pixplaze.warcell.world;

public interface IChunkManager {

    IChunk getChunk(int x, int y);

    IChunk getChunk(ChunkPosition chunkPosition);

    void unloadChunk(IChunk chunk);
}
