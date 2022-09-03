package com.pixplaze.warcell.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceManager {

    private static ResourceManager instance;

    private final String absolutePath = new File("").getAbsolutePath();
    static final Logger rootLogger = LogManager.getRootLogger();

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
}
