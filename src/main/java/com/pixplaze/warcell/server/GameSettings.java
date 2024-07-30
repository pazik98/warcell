package com.pixplaze.warcell.server;

import java.util.Random;

public class GameSettings {
    private long seed;

    public GameSettings() {
        Random random = new Random();
        this.seed = random.nextLong();
    }

    public long getSeed() {
        return seed;
    }
}
