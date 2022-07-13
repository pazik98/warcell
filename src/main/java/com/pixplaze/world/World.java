package com.pixplaze.world;

import com.pixplaze.entity.Unit;
import com.pixplaze.entity.types.Empty;
import com.pixplaze.entity.Entity;
import com.pixplaze.entity.types.Wall;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Map map;
    private List<Entity> objects;

    public World(int sizeX, int sizeY) {
        this.map = new Map(sizeX, sizeY);
        this.objects = new ArrayList<>();

        for (int i = 0; i < map.getSizeX(); i++) {
            for (int j = 0; j < map.getSizeY(); j++) {
                spawnEntity(i, j, new Empty());
            }
        }
    }

    public void spawnEntity(int x, int y, Entity entity) {
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

    public void updateMap() {
        for (int i = 0; i < map.getSizeX(); i++) {
            for (int j = 0; j < map.getSizeY(); j++) {
                map.setEntityAtCell(i, j, new Empty());
            }
        }

        for (int i = 0; i < objects.size(); i++) {
            Entity object = objects.get(i);
            map.setEntityAtCell(object.getPosition().getX(), object.getPosition().getY(), object);
        }
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
