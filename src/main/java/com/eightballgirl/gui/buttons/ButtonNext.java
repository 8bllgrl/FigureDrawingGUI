package com.eightballgirl.gui.buttons;

import com.eightballgirl.constants.ImageContants;
import com.eightballgirl.photos.AssetLoader;
import com.eightballgirl.screens.SlideshowScreen;

import java.awt.*;
import java.awt.event.MouseEvent;

import static com.eightballgirl.constants.ImageContants.currentImageFilePath;
import static com.eightballgirl.constants.ImageContants.getRandomUnusedFile;

public class ButtonNext extends GuiButton {

    public ButtonNext(int x, int y, int height) {
        super(x, y, height);
        setAppearance(AssetLoader.NEXTBUTTON);
        setWidth();
        setBounds(x,y,width,height);
    }


    //render
    public void render(Graphics2D g2) {
        super.render(g2);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }


    //make it so that when the button is clicked, the timer resets to 0.
    public void mouseClicked(MouseEvent e) {
        if (isHovering){
            ImageContants.setImage(getRandomUnusedFile());
            System.out.println(currentImageFilePath);
            SlideshowScreen.counter = 0;
        }
    }


}
