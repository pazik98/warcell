package com.pixplaze.warcell.world;

import com.pixplaze.warcell.control.Commander;
import com.pixplaze.warcell.entity.Unit;
import com.pixplaze.warcell.entity.behaviour.Programmable;
import com.pixplaze.warcell.entity.types.Empty;
import com.pixplaze.warcell.entity.Entity;
import com.pixplaze.warcell.entity.types.Wall;
import com.pixplaze.warcell.server.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * The class is responsible for storing and processing chunks and entities.
 */
public class World {

    private Server server;
    private final HashMap<ChunkPosition, Chunk> chunks;

    public World(Server server)
    {
        this.server = server;
        this.chunks = new HashMap<>();
    }

    /**
     * @return the clone of chunk by (x, y).
     */
    public Chunk getChunk(int x, int y)
    {
        var chunkPosition = new ChunkPosition(x, y);
        return getChunk(chunkPosition);
    }

    /**
     * @return the clone of chunk by ChunkPosition.
     */
    protected Chunk getChunk(ChunkPosition chunkPosition)
    {
        try {
            return chunks.get(chunkPosition).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}
