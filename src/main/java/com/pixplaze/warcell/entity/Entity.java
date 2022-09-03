package com.pixplaze.warcell.entity;

import com.pixplaze.warcell.util.ResourceManager;
import com.pixplaze.warcell.world.Position;
import com.pixplaze.warcell.world.World;

import java.awt.image.BufferedImage;
import java.util.Objects;

public class Entity {

    private String name;
    private Position position;
    private World world;
    private BufferedImage texture;

    private static final BufferedImage defaultTexture = ResourceManager.getInstance().loadTexture("/entities/unit.jpg");

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
        return defaultTexture;
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
