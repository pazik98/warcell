package com.pixplaze.warcell.ui;

import com.pixplaze.warcell.util.ResourceManager;
import com.pixplaze.warcell.entity.Entity;
import com.pixplaze.warcell.world.Map;
import com.pixplaze.warcell.world.Position;
import com.pixplaze.warcell.world.World;
import org.imgscalr.Scalr;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapPanel extends JPanel {

    private static final ResourceManager resourceManager = ResourceManager.getInstance();

    private static BufferedImage emptyCellImage = resourceManager.loadTexture("dirt.jpg");

    private static final int DEFAULT_TILE_SIZE = 20;

    private float zoom = 1.0f;
    private float xCenter = 200.0f;
    private float yCenter = 400.0f;

    private final World world;

    public MapPanel(World world) {
        this.world = world;
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(400, 400));
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

    public Entity getEntityAt(int pixelX, int pixelY) {
        int tileX = Math.round((pixelX - xCenter) / zoom / getTileSize());
        int tileY = -Math.round((pixelY - yCenter) / zoom / getTileSize());
        return world.getEntity(tileX, tileY);
    }

    private void drawAtCell(Graphics2D g, int x, int y, int tileSize, BufferedImage image) {
        int xPos = Math.round(x * tileSize * zoom + xCenter);
        int yPos = Math.round(-y * tileSize * zoom + yCenter);
        g.drawImage(image, xPos, yPos, null);
    }

    private void drawField(Graphics2D g) {
        Map map = world.getMap();
        int tileSize = getTileSize();
        BufferedImage fieldTile = Scalr.resize(emptyCellImage, tileSize);

        for (int x = 0; x < map.getSizeX(); x++) {
            for (int y = 0; y < map.getSizeY(); y++) {
                drawAtCell(g, x, y, tileSize, fieldTile);
            }
        }
    }

    private void drawEntities(Graphics2D g) {
        int tileSize = getTileSize();
        for (Entity entity : world.getObjects()) {
            Position p = entity.getPosition();
            BufferedImage entityTile = Scalr.resize(entity.getDefaultTexture(), tileSize);
            switch (p.getFacing()) {
                case NORTH -> entityTile = Scalr.rotate(entityTile, Scalr.Rotation.CW_180);
                case EAST -> entityTile = Scalr.rotate(entityTile, Scalr.Rotation.CW_270);
                case WEST -> entityTile = Scalr.rotate(entityTile, Scalr.Rotation.CW_90);
            }
            drawAtCell(g, p.getX(), p.getY(), tileSize, entityTile);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawField(g2);
        drawEntities(g2);
    }
}
