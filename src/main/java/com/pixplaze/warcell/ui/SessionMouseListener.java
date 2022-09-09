package com.pixplaze.warcell.ui;

import com.pixplaze.warcell.world.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SessionMouseListener implements MouseListener {

    private Logger rootLogger = LogManager.getRootLogger();
    private MapPanel mapPanel;

    public SessionMouseListener(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        rootLogger.debug("Mouse clicked!");
        rootLogger.debug(mapPanel.getEntityAt(e.getX(), e.getY()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
