package com.pixplaze.warcell.gui;

import com.pixplaze.warcell.ResourceManager;
import com.pixplaze.warcell.world.Map;
import com.pixplaze.warcell.world.World;
import org.imgscalr.Scalr;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapPanel extends JPanel {

    private static final ResourceManager resourceManager = ResourceManager.getInstance();

    public static BufferedImage emptyCellImage;

    private static final int DEFAULT_TILE_SIZE = 20;

    private float zoom = 1.0f;
    private float xCenter = 0.0f;
    private float yCenter = 0.0f;

    private final World world;

    public MapPanel(World world) {
        this.world = world;
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(400, 400));

        initImages();
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    public float getxCenter() {
        return xCenter;
    }

    public void setxCenter(float xCenter) {
        this.xCenter = xCenter;
    }

    public float getyCenter() {
        return yCenter;
    }

    public void setyCenter(float yCenter) {
        this.yCenter = yCenter;
    }

    public World getWorld() {
        return world;
    }

    private int getTileSize() {
        return Math.round(DEFAULT_TILE_SIZE * zoom);
    }

    private void drawCell(Graphics2D g, int x, int y, int size, BufferedImage image) {
        g.drawImage(image, x, y, null);
    }

    private void drawField(Graphics2D g) {
        Map map = world.getMap();
        int tileSize = getTileSize();
        BufferedImage fieldTile = Scalr.resize(emptyCellImage, tileSize);

        for (int x = 0; x < map.getSizeX(); x++) {
            for (int y = 0; y < map.getSizeY(); y++) {
                int xPos = Math.round(x * tileSize * zoom);
                int yPos = Math.round(y * tileSize * zoom);
                drawCell(g, xPos, yPos, tileSize, fieldTile);
            }
        }
    }

    private void initImages() {
        emptyCellImage = resourceManager.loadImage("dirt-0.jpg");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawField(g2);
    }
}
