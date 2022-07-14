package com.pixplaze.warcell.gui;

import com.pixplaze.warcell.world.World;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(World world) {
        this.setPreferredSize(new Dimension(800, 600));
        initOptions();
    }

    public GamePanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        initOptions();
    }

    public void initOptions() {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLayout(new BorderLayout());
    }

    public void initMapPanel(World world) {
        this.add(new MapPanel(world));
    }
}
