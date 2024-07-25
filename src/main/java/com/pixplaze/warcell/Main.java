package com.pixplaze.warcell;

import com.pixplaze.warcell.entity.types.Miner;
import com.pixplaze.warcell.entity.types.Wall;
import com.pixplaze.warcell.ui.ClientWindow;
import com.pixplaze.warcell.world.ChunkPosition;
import com.pixplaze.warcell.world.Simulation;
import com.pixplaze.warcell.world.World;

public class Main {
    public static void main(String[] args) {
        var cp1 = new ChunkPosition(5, 5);
        var cp2 = new ChunkPosition(5, 5);

        if (cp1.equals(cp2)) {
            System.out.println("equals!!");
        }

        /*
        ClientWindow clientWindow = new ClientWindow();

        World world = new World(20, 20);
        Simulation simulation = new Simulation(world);

        world.spawnEntity(2, 3, new Wall());
        world.spawnEntity(4, 3, new Wall());

        world.spawnEntity(9, 9, new Miner());
        world.spawnEntity(0, 0, new Miner());
        world.spawnEntity(4, 9, new Miner());
        world.spawnEntity(0, 9, new Miner());

        clientWindow.initGamePanel(world);

        Runnable renderWindow = clientWindow::start;
        new Thread(renderWindow).start();

        Runnable calculateSimulation = simulation::start;
        new Thread(calculateSimulation).start();
        */
    }
}
