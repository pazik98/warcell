package com.pixplaze.warcell.util;

import com.pixplaze.warcell.inventory.ItemType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    /**
     * Responsible for loading and using game media resources
     */

    private static ResourceManager instance;

    private final String absolutePath = new File("").getAbsolutePath();
    private static final Logger rootLogger = LogManager.getRootLogger();
    private final Map<String, BufferedImage> textureMap = new HashMap<>();


    public ResourceManager() {
        textureMap.put("default", loadTexture("default.png"));
        textureMap.put("entity.empty-tile", loadTexture("entities/empty_tile.png"));
        textureMap.put("entity.default-unit", loadTexture("entities/default_unit.png"));
        textureMap.put("entity.wall", loadTexture("entities/wall.png"));
        textureMap.put("item.empty-cell", loadTexture("items/empty_cell.png"));
        textureMap.put("item.stone", loadTexture("items/stone.png"));
    }

    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }

    public BufferedImage loadTexture(String fileName) {
        rootLogger.log(Level.DEBUG, "Loading texture " + fileName);
        File imageFile = new File(absolutePath + "\\src\\main\\resources\\textures\\" + fileName);
        BufferedImage image = new BufferedImage(1, 1, 1);
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            rootLogger.log(Level.ERROR, "Can't get texture from " + imageFile);
            e.printStackTrace();
        }
        return image;
    }

    public BufferedImage getTexture(String name) {
        if (!textureMap.containsKey(name)) {
            return textureMap.get("default");
        }
        return textureMap.get(name);
    }

    public BufferedImage getItemTexture(ItemType itemType) {
        switch (itemType) {
            case STONE -> {
                return getTexture("item.stone");
            }
        }
        return null;
    }
}
