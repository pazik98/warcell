package com.pixplaze.warcell.world;

public class Simulation {

    private int step = 0;
    private final World world;

    public Simulation(World world) {
        this.world = world;
    }

    public void nextStep() {
        world.updateObjects();
        world.updateMap();
        step++;
    }

    public void start() {
        while (true) {
            nextStep();
        }
    }

    public void start(int steps) {
        for (int i = 0; i < steps; i++) {
            nextStep();
        }
    }

    public World getWorld() {
        return world;
    }
}
