package com.eightballgirl.main;

import com.eightballgirl.constants.AppConstants;

import javax.swing.*;
import java.awt.*;

//https://docs.oracle.com/javase/tutorial/uiswing/misc/jlayer.html

public class ApplicationRenderer extends JPanel {

    private final Application app;

    public ApplicationRenderer(Application app) {
        this.app = app;
        addKeyListener(app.keyboardHandler);
        addMouseListener(app.mouseHandler);
        addMouseMotionListener(app.mouseHandler);

        //keyboard
        setPanelSize();
    }

    private void setPanelSize() {
        Dimension panelsize = new Dimension(AppConstants.APPLICATION_WIDTH, AppConstants.APPLICATION_HEIGHT);
        setPreferredSize(panelsize);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        ///////////////////////////////////////////////////////
        //Set  anti-alias!
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Set anti-alias for text
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        ///////////////////////////////////////////////////////
        app.render(g2);
        //stays at bottom
        g2.dispose();
    }

    public Application getApp() {
        return app;
    }
}
