package com.pixplaze.warcell.entity;

import com.pixplaze.warcell.control.Commander;
import com.pixplaze.warcell.util.ResourceManager;
import com.pixplaze.warcell.world.Position;
import com.pixplaze.warcell.world.World;

import java.awt.image.BufferedImage;
import java.util.Objects;

public abstract class Entity {

    private String name;
    private Position position;
    private World world;
    private BufferedImage texture;
    private Commander owner;

    private static final ResourceManager resourceManager = ResourceManager.getInstance();

    public Entity() {
        name = "Entity";
        position = new Position();
        setTexture(getDefaultTexture());
    }

    public Entity(String name) {
        this.name = name;
        position = new Position();
        setTexture(getDefaultTexture());
    }

    public Entity(String name, int x, int y) {
        this.name = name;
        position = new Position(x, y);
        setTexture(getDefaultTexture());
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

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public BufferedImage getDefaultTexture() {
        return resourceManager.getTexture("default");
    }

    public Commander getOwner() {
        return owner;
    }

    public void setOwner(Commander owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return position.equals(entity.position) && world.equals(entity.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, world);
    }
}
