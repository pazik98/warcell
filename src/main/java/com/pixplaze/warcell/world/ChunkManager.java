package com.pixplaze.warcell.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The class is responsible for storing and processing chunks.
 */
public class ChunkManager implements IChunkManager {

    private final HashMap<ChunkPosition, IChunk> chunks;

    private final IChunkLoader chunkLoader;
    private final IChunkGenerator chunkGenerator;
    private final IChunkSaver chunkSaver;

    private final World world;


    public ChunkManager(World world) {
        this.world = world;
        this.chunks = new HashMap<>();
        this.chunkLoader = new ChunkLoader();
        this.chunkGenerator = new ChunkGenerator();
        this.chunkSaver = new ChunkSaver();
    }

    /**
     * @return the chunk by (x, y).
     */
    @Override
    public IChunk getChunk(int x, int y)
    {
        var chunkPosition = new ChunkPosition(x, y, world);
        return getChunk(chunkPosition);
    }

    /**
     * @return the chunk by ChunkPosition.
     */
    @Override
    public IChunk getChunk(ChunkPosition chunkPosition)
    {
        if (!chunks.containsKey(chunkPosition)) {
            return loadChunk(chunkPosition);
        }
        return chunks.get(chunkPosition);
    }

    @Override
    public void unloadChunk(IChunk chunk) {
        saveChunk(chunk);
    }

    protected void saveChunk(IChunk chunk) {
        chunkSaver.save(chunk);
    }

    public void saveAllChunks() {
        for (IChunk chunk : chunks.values()) {
            saveChunk(chunk);
        }
    }

    protected IChunk loadChunk(ChunkPosition chunkPosition) {
        IChunk loadedChunk = chunkLoader.load(chunkPosition);

        if (loadedChunk != null) return loadedChunk;
        else {
            IChunk generatedChunk = chunkGenerator.generate(chunkPosition, world.getRandom());
            chunks.put(chunkPosition, generatedChunk);
            return generatedChunk;
        }

    }
}
