package com.pixplaze.warcell;

import com.pixplaze.warcell.entity.types.Miner;
import com.pixplaze.warcell.entity.types.Wall;
import com.pixplaze.warcell.server.Server;
import com.pixplaze.warcell.server.ServerSettings;
import com.pixplaze.warcell.ui.ClientWindow;
import com.pixplaze.warcell.world.ChunkPosition;
import com.pixplaze.warcell.world.IChunk;
import com.pixplaze.warcell.world.Simulation;
import com.pixplaze.warcell.world.World;

public class Main {

    private static void printChunk(IChunk chunk) {
        for (int i = 0; i < IChunk.CHUNK_SIZE; i++) {
            String line = "";
            for (int j = 0; j < IChunk.CHUNK_SIZE; j++) {
                line += chunk.getCell(i, j).getCellType().toString() + " ";
            }
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        World world = new World(new Server(new ServerSettings()), "world-1");
        IChunk chunk = world.getChunk(new ChunkPosition(1, 1, world));
        world.unloadChunk(chunk);
        IChunk chunk2 = world.getChunk(chunk.getChunkPosition());
        printChunk(chunk);
        System.out.println();
        printChunk(chunk2);



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
