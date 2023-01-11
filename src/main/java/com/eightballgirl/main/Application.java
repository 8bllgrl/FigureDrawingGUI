package com.eightballgirl.main;

import com.eightballgirl.constants.AppConstants;
import com.eightballgirl.inputs.KeyboardHandler;
import com.eightballgirl.inputs.MouseHandler;
import com.eightballgirl.screens.ChoiceScreen;
import com.eightballgirl.screens.Screen;
import com.eightballgirl.screens.SlideshowScreen;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class Application implements Runnable {

    private int FPS = 10;
    private final int TICKSPEED = 200;


    public ApplicationRenderer appRender;
    public ApplicationWindow window;
    @Nullable
    public Screen screen;
    public final MouseHandler mouseHandler;
    public final KeyboardHandler keyboardHandler;
    Thread appThread;


    public Application(int intervalLength, boolean quickStart) {
        this.mouseHandler = new MouseHandler(this);
        this.keyboardHandler = new KeyboardHandler(this);


        if (quickStart) {
            setScreen(new SlideshowScreen(intervalLength));
        } else {
            setScreen(new ChoiceScreen());
        }

        appRender = new ApplicationRenderer(this);
        window = new ApplicationWindow(appRender);
        appRender.setFocusable(true);
        appRender.requestFocus();

        appThread = new Thread(this);
        appThread.start();
    }

    public void render(Graphics2D g2) {
        this.screen.render(g2);
    }

    public void setScreen(@Nullable Screen screenPassedIn) {
        if (this.screen != null) {
            this.screen.removed(); //TODO
        }
        if (screenPassedIn == null) {
            screenPassedIn = new ChoiceScreen();
            screenPassedIn.init(this, AppConstants.APPLICATION_WIDTH, AppConstants.APPLICATION_HEIGHT);
//            screenPassedIn.init();
        }

        this.screen = screenPassedIn;
        screenPassedIn.init(this, AppConstants.APPLICATION_WIDTH, AppConstants.APPLICATION_HEIGHT);
//        screenPassedIn.init();

    }


    //setscreen method
    //render method
    //getscreen
    public Screen getScreen() {
        return screen;
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / TICKSPEED;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaUpdate = 0;
        double deltaFrame = 0;

        while (appThread != null) {
            long currentTime = System.nanoTime();

            deltaUpdate += (currentTime - previousTime) / timePerUpdate;
            deltaFrame += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaUpdate >= 1) {
                screen.update();
                updates++;
                deltaUpdate--;
            }

            if (deltaFrame >= 1) {
                appRender.repaint();
                frames++;
                deltaFrame--;

            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
//                System.out.println("FPS: " + frames + " |  UPS:" + updates);
                setFPS(frames);

                updates = 0;
                frames = 0;
            }
        }
    }

    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

}
