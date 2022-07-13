package com.pixplaze.warcell;

import com.pixplaze.warcell.entity.Unit;
import com.pixplaze.warcell.entity.types.Wall;
import com.pixplaze.warcell.gui.ClientWindow;
import com.pixplaze.warcell.world.Simulation;
import com.pixplaze.warcell.world.World;

public class Main {
    public static void main(String[] args) {
        ClientWindow clientWindow = new ClientWindow();

        World world = new World(10, 10);
        Simulation simulation = new Simulation(world);

        world.spawnEntity(2, 3, new Wall());
        world.spawnEntity(4, 3, new Wall());
        Unit unit = new Unit();
        world.spawnEntity(1, 1, unit);
        world.spawnEntity(2, 2, unit);

        Unit unit2 = new Unit();
        world.spawnEntity(1, 1, unit2);
        world.spawnEntity(5, 5, unit2);

        clientWindow.initMapPanel(world);
        clientWindow.run();

        simulation.start(10);

        System.out.println(world);
    }
}
