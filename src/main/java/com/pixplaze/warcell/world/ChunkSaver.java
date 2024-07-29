package com.pixplaze.warcell.world;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChunkSaver implements IChunkSaver {

    @Override
    public void save(IChunk chunk) {
        String path = "src\\main\\resources\\save\\" + chunk.getChunkPosition().getWorld().getName() + "\\chunks";

        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filename = chunk.getChunkPosition().getX() + "-" + chunk.getChunkPosition().getY() + ".wcc";

        writeChunk(path + "\\" + filename, chunk);
    }

    public void writeChunk(String path, IChunk chunk) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, false)) {
            for (int i = 0; i < IChunk.CHUNK_SIZE; i++) {
                for (int j = 0; j < IChunk.CHUNK_SIZE; j++) {
                    Integer cellType = chunk.getCell(i, j).getCellType().ordinal();
                    byte buffer = cellType.byteValue();
                    fileOutputStream.write(buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
