package com.pixplaze.warcell.world;

import java.io.File;

public class WorldLoader implements IWorldLoader {

    private String worldDirectoryPath;

    private IChunkLoader chunkLoader;

    WorldLoader(String worldDirectoryPath) {
        this.worldDirectoryPath = worldDirectoryPath;
        this.chunkLoader = new ChunkLoader();
    }

    @Override
    public World load() {
        return null;
    }

    private File readFile(String filePath) {
        return null;
    }
}
