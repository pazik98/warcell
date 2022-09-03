package com.pixplaze.warcell.entity.types;

import com.pixplaze.warcell.entity.Entity;
import com.pixplaze.warcell.util.ResourceManager;

import java.awt.image.BufferedImage;

public class Wall extends Entity {

    private static final BufferedImage defaultTexture = ResourceManager.getInstance().loadTexture("/entities/wall.jpg");

    public Wall() {
        super("Wall");
    }

    @Override
    public BufferedImage getDefaultTexture() {
        return defaultTexture;
    }
}
