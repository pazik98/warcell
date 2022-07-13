package com.pixplaze.warcell.gui;

import com.pixplaze.warcell.world.World;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(World world) {
        this.setPreferredSize(new Dimension(800, 600));
        initOptions();
        initMapPanel(world);
    }

    public GamePanel(int width, int height, World world) {
        this.setPreferredSize(new Dimension(width, height));
        initOptions();
        initMapPanel(world);
    }

    public void initOptions() {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
    }

    public void initMapPanel(World world) {
        this.add(new MapPanel(world));
    }
}
