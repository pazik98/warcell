package com.pixplaze.warcell.gui;

import com.pixplaze.warcell.world.FacingType;
import com.pixplaze.warcell.world.World;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame implements Runnable {

    public ClientWindow() throws HeadlessException {
        System.out.println("Creating window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle("WarCell v1.0");

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initGamePanel(World world) {
        GamePanel mainPanel = new GamePanel(800, 600);
        MapPanel mapPanel = new MapPanel(world);
        addKeyListener(new KeyboardListener(mapPanel));
        mainPanel.add(mapPanel);
        add(mainPanel);
        pack();
    }

    @Override
    public void run() {
        System.out.println("Running GUI window...");
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
