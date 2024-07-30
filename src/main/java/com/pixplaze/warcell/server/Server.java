package com.pixplaze.warcell.server;

import com.pixplaze.warcell.control.Commander;
import com.pixplaze.warcell.util.ConfigManager;
import com.pixplaze.warcell.world.World;

import java.util.Random;

public class Server {

    private final ConfigManager configManager;

    private final World world;

    public Server() {
        this.configManager = new ConfigManager();
        this.world = createWorld();
    }

    public ServerSettings getServerSettings() {
        return configManager.getServerSettings();
    }

    public GameSettings getGameSettings() {
        return configManager.getGameSettings();
    }

    public long getSeed() {
        return configManager.getGameSettings().getSeed();
    }

    private World createWorld() {
        return new World(this, "world-1");
    }

    public World getWorld() {
        return world;
    }
}
