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

import java.util.*;

public class World {

    private Server server;
    private ChunkManager chunkManager;
    private String name;


    public World(Server server, String name)
    {
        this.server = server;
        this.chunkManager = new ChunkManager(this);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IChunk getChunk(ChunkPosition chunkPosition) {
        try {
            return chunkManager.getChunk(chunkPosition.getX(), chunkPosition.getY()).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public void save() {
        chunkManager.saveAllChunks();
    }

    // TEMPORARY
    public void unloadChunk(IChunk chunk) {
        chunkManager.unloadChunk(chunk);
    }

    public Random getRandom() {
        return server.getRandom();
    }
}
