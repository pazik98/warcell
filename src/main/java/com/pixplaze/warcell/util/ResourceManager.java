package com.pixplaze.warcell.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceManager {

    private static ResourceManager instance;

    private final String absolutePath = new File("").getAbsolutePath();

    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }

    public BufferedImage loadTexture(String fileName) {
        File imageFile = new File(absolutePath + "\\src\\main\\resources\\textures\\" + fileName);
        BufferedImage image = new BufferedImage(1, 1, 1);
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
