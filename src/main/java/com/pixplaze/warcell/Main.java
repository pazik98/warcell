package com.pixplaze.warcell;

import com.pixplaze.warcell.entity.types.SimpleMiner;
import com.pixplaze.warcell.entity.types.Wall;
import com.pixplaze.warcell.inventory.ItemStack;
import com.pixplaze.warcell.inventory.ItemType;
import com.pixplaze.warcell.ui.ClientWindow;
import com.pixplaze.warcell.world.Simulation;
import com.pixplaze.warcell.world.World;

public class Main {
    public static void main(String[] args) {
        ClientWindow clientWindow = new ClientWindow();

        World world = new World(20, 20);
        Simulation simulation = new Simulation(world);

        world.spawnEntity(2, 3, new Wall());
        world.spawnEntity(4, 3, new Wall());
        world.spawnEntity(6, 6, new Wall());
        world.spawnEntity(7, 7, new Wall());



        //world.spawnEntity(9, 9, new SimpleMiner());
        //world.spawnEntity(0, 0, new SimpleMiner());
        //world.spawnEntity(4, 9, new SimpleMiner());
        SimpleMiner miner = new SimpleMiner();
        miner.getInventory().add(new ItemStack(20, ItemType.STONE));
        world.spawnEntity(0, 9, miner);

        clientWindow.initGamePanel(world);

        Runnable renderWindow = clientWindow::start;
        new Thread(renderWindow).start();

        Runnable calculateSimulation = simulation::start;
        new Thread(calculateSimulation).start();
    }
}
