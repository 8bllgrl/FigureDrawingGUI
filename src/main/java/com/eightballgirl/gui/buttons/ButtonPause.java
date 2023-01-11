package com.eightballgirl.gui.buttons;

import com.eightballgirl.constants.ImageContants;
import com.eightballgirl.screens.SlideshowScreen;

import java.awt.*;
import java.awt.event.MouseEvent;

import static com.eightballgirl.constants.ImageContants.currentImageFilePath;
import static com.eightballgirl.constants.ImageContants.getRandomUnusedFile;

public class ButtonPause extends GuiButton {
    final String PAUSEBUTTON = "/img/gui/button/circle-pause-solid.png";

    public ButtonPause(int x, int y, int height) {
        super(x, y, height);
        setAppearance(PAUSEBUTTON);
        setWidth();
        setBounds(x, y, width, height);
    }

    //render
    public void render(Graphics2D g2) {
        super.render(g2);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }

    public void mouseClicked(MouseEvent e) {
        if (isHovering) {

            if (!SlideshowScreen.isPaused()) {
                SlideshowScreen.pause();
                System.out.println("paused");

            } else {
                SlideshowScreen.unpause();
                System.out.println("unpaused");
            }

        }
    }
}
