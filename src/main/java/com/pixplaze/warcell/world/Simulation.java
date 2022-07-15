package com.pixplaze.warcell.world;

public class Simulation {

    private int step = 0;
    private final World world;
    private int latency = 1000/60;

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
            try {
                Thread.sleep(latency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
