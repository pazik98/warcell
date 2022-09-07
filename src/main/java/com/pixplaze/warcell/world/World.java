package com.pixplaze.warcell.world;

import com.pixplaze.warcell.control.Commander;
import com.pixplaze.warcell.entity.Unit;
import com.pixplaze.warcell.entity.behaviour.Programmable;
import com.pixplaze.warcell.entity.types.Empty;
import com.pixplaze.warcell.entity.Entity;
import com.pixplaze.warcell.entity.types.Wall;
import com.pixplaze.warcell.server.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Server server;
    private Map map;
    private List<Entity> objects;

    static final Logger rootLogger = LogManager.getRootLogger();

    public World(int sizeX, int sizeY) {
        this.map = new Map(sizeX, sizeY);
        this.objects = new ArrayList<>();
        this.server = Server.getInstance();
        clearMap();
    }

    public void spawnEntity(int x, int y, Entity entity) {
        if (!isEmpty(x, y)) {
            rootLogger.warn("Cannot spawn entity at [" + x + ", " + y);
            return;
        }

        if (entity.getWorld() != null && objects.contains(entity)) {
            rootLogger.warn("Entity already spawned at this world!");
            return;
        }

        map.setEntityAtCell(x, y, entity);
        objects.add(entity);
        entity.setWorld(this);
        entity.setOwner(server);
        entity.getPosition().setX(x);
        entity.getPosition().setY(y);
    }

    public void spawnEntity(int x, int y, Entity entity, Commander owner) {
        spawnEntity(x, y, entity);
        entity.setOwner(owner);
    }

    public Entity getEntity(int x, int y) {
        rootLogger.debug("Entity at cell [" + x + ", " + y + "] is " + map.getEntityAtCell(x, y));
        return map.getEntityAtCell(x, y);
    }

    public boolean isEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > map.getSizeX()-1 || y > map.getSizeY()-1) {
            return false;
        }
        return getEntity(x, y) instanceof Empty;
    }

    public void clearCell(int x, int y) {
        map.setEntityAtCell(x, y, new Empty());
    }

    public void clearMap() {
        for (int i = 0; i < map.getSizeX(); i++) {
            for (int j = 0; j < map.getSizeY(); j++) {
                clearCell(i, j);
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
            if (entity instanceof Programmable) {
                ((Programmable) entity).executeActualCommand();
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
