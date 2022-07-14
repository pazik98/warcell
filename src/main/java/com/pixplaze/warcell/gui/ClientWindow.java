package com.pixplaze.warcell.gui;

import com.pixplaze.warcell.world.FacingType;
import com.pixplaze.warcell.world.World;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame implements Runnable {

    private GamePanel mainPanel;
    private MapPanel mapPanel;
    private JPanel infoPanel;

    public ClientWindow() throws HeadlessException {
        System.out.println("Creating window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("WarCell v1.0");

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initGamePanel(World world) {
        mainPanel = new GamePanel(800, 600);
        mapPanel = new MapPanel(world);
        mainPanel.add(mapPanel);
        this.add(mainPanel);
        this.pack();
    }

    @Override
    public void run() {
        System.out.println("Running GUI window...");
        while (true) {
//            try {
//                Thread.sleep(1000/60);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            repaint();
        }
    }
}
