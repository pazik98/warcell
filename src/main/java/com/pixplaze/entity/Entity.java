package com.pixplaze.entity;

import com.pixplaze.world.Position;
import com.pixplaze.world.World;

public class Entity {

    private String name;
    private Position position;
    private World world;

    public Entity(String name) {
        this.name = name;
        this.position = new Position();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
