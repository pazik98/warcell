package com.pixplaze.warcell.entity.types;

import com.pixplaze.warcell.entity.Entity;
import com.pixplaze.warcell.util.ResourceManager;

import java.awt.image.BufferedImage;

public class Wall extends Entity {

    private static final ResourceManager resourceManager = ResourceManager.getInstance();

    public Wall() {
        super("Wall");
    }

    @Override
    public BufferedImage getDefaultTexture() {
        return resourceManager.getTexture("entity.wall");
    }
}
