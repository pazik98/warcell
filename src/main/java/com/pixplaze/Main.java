package com.pixplaze;

import com.pixplaze.entity.Unit;
import com.pixplaze.entity.types.Wall;
import com.pixplaze.world.World;

public class Main {
    public static void main(String[] args) {
        World world = new World(10, 10);
        world.spawnEntity(2, 3, new Wall());
        world.spawnEntity(4, 3, new Wall());
        Unit unit = new Unit();
        world.spawnEntity(1, 1, unit);
        unit.executeActualCommand();
        unit.executeActualCommand();
        unit.executeActualCommand();
        unit.executeActualCommand();
        unit.executeActualCommand();
        unit.executeActualCommand();
        world.updateMap();
        System.out.println(world);
    }
}
