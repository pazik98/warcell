package com.pixplaze.warcell.world;

import com.pixplaze.warcell.entity.Unit;
import com.pixplaze.warcell.entity.behaviour.IProgrammable;
import com.pixplaze.warcell.entity.types.Empty;
import com.pixplaze.warcell.entity.Entity;
import com.pixplaze.warcell.entity.types.Wall;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Map map;
    private List<Entity> objects;

    public World(int sizeX, int sizeY) {
        this.map = new Map(sizeX, sizeY);
        this.objects = new ArrayList<>();
        clearMap();
    }

    public void spawnEntity(int x, int y, Entity entity) {
        if (!isEmpty(x, y)) {
            System.out.printf("Cannot spawn entity at %d %d!", x, y);
            return;
        }

        if (objects.contains(entity)) {
            System.out.println("Entity already spawned at this world!");
            return;
        }

        map.setEntityAtCell(x, y, entity);
        objects.add(entity);
        entity.setWorld(this);
        entity.getPosition().setX(x);
        entity.getPosition().setY(y);
    }

    public Entity getEntity(int x, int y) {
        System.out.printf("Entity at cell %d %d is %s\n", x, y, map.getEntityAtCell(x, y));
        return map.getEntityAtCell(x, y);
    }

    public boolean isEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > map.getSizeX()-1 || y > map.getSizeY()-1) {
            return false;
        }
        return getEntity(x, y) instanceof Empty;
    }

    public void clearMap() {
        for (int i = 0; i < map.getSizeX(); i++) {
            for (int j = 0; j < map.getSizeY(); j++) {
                map.setEntityAtCell(i, j, new Empty());
            }
        }
    }

    public void updateMap() {
        clearMap();
        for (Entity object : objects) {
            map.setEntityAtCell(object.getPosition().getX(), object.getPosition().getY(), object);
        }
    }

    public Map getMap() {
        return map;
    }

    public void updateObjects() {
        for (Entity entity : objects) {
            if (entity instanceof IProgrammable) {
                ((IProgrammable) entity).executeActualCommand();
            }
        }
    }

    public List<Entity> getObjects() {
        return new ArrayList<>(objects);
    }

    @Override
    public String toString() {
        String world = "";
        for (int i = 0; i < map.getSizeX(); i++) {
            for (int j = 0; j < map.getSizeY(); j++) {
                world += "[";
                Entity entity = map.getEntityAtCell(j, i);

                if (entity instanceof Empty) world += " ";
                if (entity instanceof Wall) world += "W";
                if (entity instanceof Unit) world += "U";

                world += "]";
            }
            world += "\n";
        }
        return world;
    }
}
