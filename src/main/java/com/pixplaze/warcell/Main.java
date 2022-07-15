package com.pixplaze.warcell;

import com.pixplaze.warcell.entity.Unit;
import com.pixplaze.warcell.entity.types.Wall;
import com.pixplaze.warcell.gui.ClientWindow;
import com.pixplaze.warcell.world.FacingType;
import com.pixplaze.warcell.world.Simulation;
import com.pixplaze.warcell.world.World;

public class Main {
    public static void main(String[] args) {
        ClientWindow clientWindow = new ClientWindow();

        World world = new World(20, 20);
        Simulation simulation = new Simulation(world);

        world.spawnEntity(2, 3, new Wall());
        world.spawnEntity(4, 3, new Wall());
        Unit unit = new Unit();
        world.spawnEntity(1, 1, unit);
        world.spawnEntity(2, 2, unit);

        Unit unit2 = new Unit();
        world.spawnEntity(1, 1, unit2);
        world.spawnEntity(5, 5, unit2);

        Unit unit3 = new Unit();
        world.spawnEntity(9, 9, unit3);
        unit3.getPosition().setFacing(FacingType.EAST);

        clientWindow.initGamePanel(world);

        Runnable renderWindow = clientWindow::start;
        new Thread(renderWindow).start();

        Runnable calculateSimulation = simulation::start;
        new Thread(calculateSimulation).start();
    }
}
