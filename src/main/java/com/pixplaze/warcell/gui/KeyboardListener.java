package com.pixplaze.warcell.gui;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private MapPanel mapPanel;
    static final Logger rootLogger = LogManager.getRootLogger();

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
                rootLogger.log(Level.DEBUG, "Up key pressed");
                break;
            case KeyEvent.VK_DOWN:
                mapPanel.moveCameraY(-offset);
                rootLogger.log(Level.DEBUG, "Down key pressed");
                break;
            case KeyEvent.VK_RIGHT:
                mapPanel.moveCameraX(offset);
                rootLogger.log(Level.DEBUG, "Right key pressed");
                break;
            case KeyEvent.VK_LEFT:
                mapPanel.moveCameraX(-offset);
                rootLogger.log(Level.DEBUG, "Left key pressed");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
