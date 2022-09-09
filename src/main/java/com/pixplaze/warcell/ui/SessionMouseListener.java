package com.pixplaze.warcell.ui;

import com.pixplaze.warcell.world.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SessionMouseListener implements MouseListener {

    private Logger rootLogger = LogManager.getRootLogger();
    private MapPanel mapPanel;
    private EntityPanel entityPanel;

    public SessionMouseListener(MapPanel mapPanel, EntityPanel entityPanel) {
        this.mapPanel = mapPanel;
        this.entityPanel = entityPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        entityPanel.setEntity(mapPanel.getEntityAt(e.getX(), e.getY()));
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
