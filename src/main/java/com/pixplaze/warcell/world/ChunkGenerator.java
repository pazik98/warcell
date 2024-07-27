package com.pixplaze.warcell.world;

import java.util.Random;

public class ChunkGenerator implements IChunkGenerator {

    /**
     * @return a reference to the new generated chunk.
     */
    @Override
    public Chunk generate(ChunkPosition chunkPosition, Random random) {
        var chunk = new Chunk(chunkPosition);
        for (int i = 0; i < IChunk.CHUNK_SIZE; i++) {
            for (int j = 0; j < IChunk.CHUNK_SIZE; j++) {
                float r = random.nextFloat();
                CellType cellType;
                if (r < 0.15) {
                    cellType = CellType.BLOCK;
                }
                else {
                    cellType = CellType.VOID;
                }
                chunk.setCell(new Cell(cellType), i, j);
            }
        }
        return chunk;
    }
}
