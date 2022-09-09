package com.pixplaze.warcell.ui;

import javax.swing.*;
import java.awt.*;

public class UnitPanel extends JPanel {

    public UnitPanel(int width) {
        setPreferredSize(new Dimension(width, 600));
        setBackground(Color.RED);
        setDoubleBuffered(true);
    }
}
