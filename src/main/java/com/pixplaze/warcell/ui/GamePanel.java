package com.pixplaze.warcell.ui;

import com.pixplaze.warcell.world.World;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(World world) {
        setPreferredSize(new Dimension(800, 600));
        initOptions();
    }

    public GamePanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        initOptions();
    }

    public void initOptions() {
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        setLayout(new BorderLayout());
    }

    public void initMapPanel(World world) {
        add(new MapPanel(world));
    }
}
