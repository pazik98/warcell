package com.pixplaze.warcell.ui;

import com.pixplaze.warcell.entity.Entity;
import com.pixplaze.warcell.entity.behaviour.Miner;
import com.pixplaze.warcell.inventory.ItemStack;
import com.pixplaze.warcell.inventory.ItemType;
import com.pixplaze.warcell.inventory.Storage;
import com.pixplaze.warcell.util.ResourceManager;
import org.imgscalr.Scalr;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EntityPanel extends JPanel {

    private Entity entity;
    private final BufferedImage EMPTY_CELL = ResourceManager.getInstance().loadTexture("empty_cell.png");

    public EntityPanel(int width) {
        setPreferredSize(new Dimension(width, 600));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawInfo(g2d);
    }

    private void drawInfo(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);

        if (entity == null) {
            drawTitle(g2d, "No selected entity", 20);
            return;
        }

        drawTitle(g2d, entity.getName(), 20);
        drawParam(g2d, "position: " + entity.getPosition().getX() + " " + entity.getPosition().getY(), 40);
        if (entity instanceof Miner) {
            drawTitle(g2d, "Inventory", 60);
            drawInventory(g2d, (Storage) ((Miner) entity).getInventory(), 70);
        }

    }

    private void drawTitle(Graphics2D g2d, String text, int height) {
        g2d.setFont(new Font("Consolas", Font.BOLD, 20));
        drawCenteredString(g2d, text, height);
    }

    private void drawParam(Graphics2D g2d, String text, int height) {
        g2d.setFont(new Font("Consolas", Font.PLAIN, 14));
        g2d.drawString(text, 10, height);
    }

    private void drawCenteredString(Graphics2D g2d, String string, int height) {
        FontMetrics fontMetrics = g2d.getFontMetrics();
        int x = getWidth()/2 - fontMetrics.stringWidth(string)/2;
        g2d.drawString(string, x, height);
    }

    private void drawInventory(Graphics2D g2d, Storage storage, int height) {
        int cellSize = 64;

        for (int i = 0; i < storage.getSize(); i++) {
            g2d.drawImage(Scalr.resize(EMPTY_CELL, cellSize, cellSize), null, i * cellSize, height);
            ItemType type = storage.getItem(i).getItemType();
            if (!type.equals(ItemType.EMPTY)) {
                g2d.drawImage(Scalr.resize(ResourceManager.getInstance().getItemTexture(type), cellSize, cellSize),
                        null, i * cellSize, height);
            }
        }
    }
}
