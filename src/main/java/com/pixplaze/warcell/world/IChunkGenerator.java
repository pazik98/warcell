package com.pixplaze.warcell.world;

import java.util.Random;

public interface IChunkGenerator {

    IChunk generate(ChunkPosition chunkPosition, Random random);
}
