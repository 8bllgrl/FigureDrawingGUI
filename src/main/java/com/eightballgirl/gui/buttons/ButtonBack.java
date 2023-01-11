package com.eightballgirl.gui.buttons;

import com.eightballgirl.constants.ImageContants;
import com.eightballgirl.photos.AssetLoader;
import com.eightballgirl.screens.SlideshowScreen;

import java.awt.*;
import java.awt.event.MouseEvent;

import static com.eightballgirl.constants.ImageContants.*;

public class ButtonBack extends GuiButton {

    public ButtonBack(int x, int y, int height) {
        super(x, y, height);
        setAppearance(AssetLoader.BACKBUTTON);
        setWidth();
        setBounds(x,y,width,height);
    }

    @Override
    public void render(Graphics2D g2) {
        super.render(g2);
        g2.drawRect(x, y, width, height);
    }

    public boolean isHovered(MouseEvent e) {
        return this.bounds.contains(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }

    public void mouseClicked(MouseEvent e) {
        if (isHovering){
            if (usedImages.size()!=1){
                ImageContants.setImage(getPreviousImage());
                System.out.println(currentImageFilePath);
                SlideshowScreen.counter = 0;
            }
        }
    }

}
