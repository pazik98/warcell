package com.pixplaze.warcell.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private MapPanel mapPanel;

    public KeyboardListener(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int offset = mapPanel.getMoveOffset();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                mapPanel.moveCameraY(offset);
                System.out.println("UP PRESSED");
                break;
            case KeyEvent.VK_DOWN:
                mapPanel.moveCameraY(-offset);
                System.out.println("DOWN PRESSED");
                break;
            case KeyEvent.VK_RIGHT:
                mapPanel.moveCameraX(offset);
                System.out.println("RIGHT PRESSED");
                break;
            case KeyEvent.VK_LEFT:
                mapPanel.moveCameraX(-offset);
                System.out.println("LEFT PRESSED");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
