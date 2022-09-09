package com.pixplaze.warcell.ui;

import com.pixplaze.warcell.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame {

    static final Logger rootLogger = LogManager.getRootLogger();

    public ClientWindow() throws HeadlessException {
        rootLogger.log(Level.DEBUG, "Creating window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle("WarCell v0.1");

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initGamePanel(World world) {
        GamePanel mainPanel = new GamePanel(800, 600);
        MapPanel mapPanel = new MapPanel(world);
        UnitPanel unitPanel = new UnitPanel(400);
        addKeyListener(new KeyboardListener(mapPanel));
        mainPanel.add(mapPanel);
        mainPanel.add(unitPanel, BorderLayout.EAST);
        add(mainPanel);
        pack();
    }

    public void start() {
        rootLogger.log(Level.DEBUG, "Running GUI window...");
        while (true) {
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
