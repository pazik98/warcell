package com.pixplaze.warcell.ui;

import com.pixplaze.warcell.entity.Entity;

import javax.swing.*;
import java.awt.*;

public class EntityPanel extends JPanel {

    private Entity entity;

    public EntityPanel(int width) {
        setPreferredSize(new Dimension(width, 600));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawInfo(g2d);
    }

    private void drawInfo(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        drawTitle(g2d, "UnitName", 20);
        drawParam(g2d, "position: x, y", 40);
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
}
