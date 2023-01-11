package com.eightballgirl.screens;

import com.eightballgirl.gui.buttons.GuiButton;
import com.eightballgirl.main.Application;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Screen {
    //children arraylist of buttons
    //width
    //height
    //app

    protected Application app;
    public int width;
    public int height;
    protected final ArrayList<GuiButton> children;


    protected Screen() {
        //children
        this.children = new ArrayList<>();
        //buttons
        //title
    }


    public void removed() {
    }

    public void init(final Application app, final int width, final int height) {
        this.app = app;
        this.width = width;
        this.height = height;
        //children
        //buttons
        init();
    }

    public void update() {

    }

    public void init() {
        //placing things on the screen.
        this.children.clear();
    }

    public void render(Graphics2D g2) {

        g2.fillRect(width / 2, height / 2, 50, 50);
    }

    protected <T extends GuiButton> T addToGuiList(T childOfScreen) {
        this.children.add(childOfScreen);
        return childOfScreen;
    }

    //
    public void keyTyped(KeyEvent e) {

        System.out.println("A Generic Screen KeyTyped Method was called.");

    }

    public ArrayList<? extends GuiButton> children() {
        return this.children;
    }

    public void mouseMoved(MouseEvent e) {
        for (GuiButton button : children) {
            button.mouseMoved(e);
        }
    }

    public void mouseClicked(MouseEvent e) {
        for (GuiButton button : children) {
            button.mouseClicked(e);
        }
    }
}
