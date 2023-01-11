package com.eightballgirl.screens;

import com.eightballgirl.constants.AppConstants;
import com.eightballgirl.constants.ImageContants;
import com.eightballgirl.gui.SlideshowDeck;
import com.eightballgirl.gui.TimerVisualizer;
import com.eightballgirl.photos.AssetLoader;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import static com.eightballgirl.constants.AppConstants.*;
import static com.eightballgirl.constants.ImageContants.absolutePathsOfImages;
import static com.eightballgirl.constants.ImageContants.getRandomUnusedFile;

public class SlideshowScreen extends Screen {

    //has a back button and a forward button
    //arraylist of photos viewed, in order.
    //method for loading in the photo and then adding it to the arraylist of photos
    //render
    //update

    //southGuiRow
    private SlideshowDeck deck;
    public TimerVisualizer timerVisualizer;
    //height of image
    //width is calculated by the height. look at csp for the maths.
    //bg color
    private Color bgColorDark = new Color(65, 66, 68);
    private BufferedImage currentImage;
    private int interval = 120000;
    public static int counter = 0;
    private static boolean isPaused;


    public SlideshowScreen(int intervalSpeed) {
        super();
        this.interval = intervalSpeed;
    }

    @Override
    public void init() {
        counter=0;
        isPaused = true;
        this.timerVisualizer = new TimerVisualizer();
        this.deck = new SlideshowDeck();
        ImageContants.init();
        currentImage = ImageContants.currentImage;
        ImageContants.usedImages = new ArrayList<>();
        System.out.println("image file paths length : " + absolutePathsOfImages.length);
        //TODO
        ImageContants.setImage(getRandomUnusedFile());
        System.out.println("Init ");
        isPaused = false;
    }

    @Override
    public void render(Graphics2D g2) {
        renderBg(g2);
        displayImage(g2);
        displaySouthDeck(g2);
        timerVisualizer.render(g2);
    }

    @Override
    public void update() {
        //every 2000 milliseconds, change photo.
        if (!isPaused) {
            timerMethod();
        }

        currentImage = ImageContants.currentImage;
    }

    public void renderBg(Graphics2D g2) {
        g2.setColor(bgColorDark);
        g2.fillRect(0, 0, width, height);
    }

    public void nextImage() {
        ImageContants.setImage(getRandomUnusedFile());
        System.out.println("Image changed.");
    }

    private void displayImage(Graphics2D g2) {
        g2.drawImage(currentImage,
                (width / 2) - AppConstants.imgDiffWidth(currentImage.getWidth(), currentImage.getHeight(), height - deck.height) / 2,
                0,
                AppConstants.imgDiffWidth(currentImage.getWidth(), currentImage.getHeight(), height - deck.height),
                height - deck.height,
                null);
    }

    private void displaySouthDeck(Graphics2D g2) {
        deck.render(g2);
    }

    private void timerMethod() {
        counter++;
        timerVisualizer.setDisplayString(Integer.toString(interval - counter));
        if (counter >= interval) {
            counter = 0;
            nextImage();
            currentImage = ImageContants.currentImage;
        }

    }

    public static void pause() {
        isPaused = true;
    }

    public static void unpause() {
        isPaused = false;
    }

    public static boolean isPaused() {
        return isPaused;
    }


    ///////////////////////////////////////////////////////

    @Override
    public void mouseMoved(MouseEvent e) {
        deck.mouseMoved(e);
    }

    public void mouseClicked(MouseEvent e) {
        deck.mouseClicked(e);
    }


}
