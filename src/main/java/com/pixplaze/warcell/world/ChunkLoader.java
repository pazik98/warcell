package com.pixplaze.warcell.world;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ChunkLoader implements IChunkLoader {

    @Override
    public IChunk load(ChunkPosition chunkPosition) {
        String saveDirectory = chunkPosition.getWorld().getServer().getServerSettings().getSavePath();
        String worldName = chunkPosition.getWorld().getName();
        String path = saveDirectory + "\\" + worldName + "\\chunks";
        String filename = chunkPosition.getX() + "-" + chunkPosition.getY() + ".wcc";
        return readChunk(path + "\\" + filename, chunkPosition);
    }

    protected IChunk readChunk(String path, ChunkPosition chunkPosition) {
        if (!new File(path).exists()) return null;

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            IChunk chunk = new Chunk(chunkPosition);

            int i;
            byte[] buffer = new byte[1];
            int m = 0;
            int n = 0;
            while ((i = fileInputStream.read(buffer)) != -1) {
                //System.out.println("read byte " + buffer[0]);
                CellType cellType = CellType.values()[buffer[0]];
                Cell cell = new Cell(cellType);
                chunk.setCell(cell, m, n);

                n++;
                if (n >= IChunk.CHUNK_SIZE && m < IChunk.CHUNK_SIZE - 1) {
                    m++;
                    n = 0;
                }
            }
            return chunk;
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}
