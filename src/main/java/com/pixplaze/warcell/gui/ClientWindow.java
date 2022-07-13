package com.pixplaze.warcell.gui;

import com.pixplaze.warcell.world.World;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame implements Runnable {

    private GamePanel mainPanel;
    private MapPanel mapPanel;

    public ClientWindow() throws HeadlessException {
        System.out.println("Creating window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("WarCell v1.0");

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initGamePanel(World world) {
        GamePanel gamePanel = new GamePanel(world);
        this.add(gamePanel);
    }

    @Override
    public void run() {
        System.out.println("Runnig window..");
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
