package com.pixplaze.warcell.gui;

import com.pixplaze.warcell.world.Map;
import com.pixplaze.warcell.world.World;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapPanel extends JPanel {

    public static BufferedImage emptyCellImage;

    private float zoom = 1.0f;
    private float xCenter = 0.0f;
    private float yCenter = 0.0f;

    private final World world;

    public MapPanel(World world) {
        this.world = world;
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(400, 400));
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

    private void drawCell(Graphics2D g, int x, int y, int size, BufferedImage image) {
        //BufferedImage sizedImage = new BufferedImage(size, size, image);
        g.drawImage(image, x, y, null);
    }

    private void drawField(Graphics2D g) {
        Map map = world.getMap();
        int tileSize = Math.round(50 * zoom);

        for (int x = 0; x < map.getSizeX(); x++) {
            for (int y = 0; y < map.getSizeY(); y++) {
                int xPos = x + x * tileSize;
                int yPos = y + y * tileSize;
                drawCell(g, xPos, yPos, tileSize, emptyCellImage);
            }
        }
    }

    private void initImages() throws IOException {
        emptyCellImage = ImageIO.read(new File("img/dirt-0.jpg"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawField(g2);
    }
}
