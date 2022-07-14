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
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(400, 400));
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

    private void setxCenter(float xCenter) {
        this.xCenter = xCenter;
    }

    public float getyCenter() {
        return yCenter;
    }

    private void setyCenter(float yCenter) {
        this.yCenter = yCenter;
    }

    public void moveCameraX(float offset) {
        xCenter -= offset;
    }

    public void moveCameraY(float offset) {
        yCenter += offset;
    }

    public World getWorld() {
        return world;
    }

    private int getTileSize() {
        return Math.round(DEFAULT_TILE_SIZE * zoom);
    }

    public int getMoveOffset() {
        return getTileSize();
    }

    private void drawCell(Graphics2D g, int x, int y, BufferedImage image) {
        g.drawImage(image, x, y, null);
    }

    private void drawField(Graphics2D g) {
        Map map = world.getMap();
        int tileSize = getTileSize();
        BufferedImage fieldTile = Scalr.resize(emptyCellImage, tileSize);

        for (int x = 0; x < map.getSizeX(); x++) {
            for (int y = 0; y < map.getSizeY(); y++) {
                int xPos = Math.round(x * tileSize * zoom + xCenter);
                int yPos = Math.round(y * tileSize * zoom + yCenter);
                drawCell(g, xPos, yPos, fieldTile);
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
