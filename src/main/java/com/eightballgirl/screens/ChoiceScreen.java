package com.eightballgirl.screens;

import com.eightballgirl.gui.buttons.GuiButton;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ChoiceScreen extends Screen {


    private int intervalLength;
    private int paneWidth;
    private int paneHeight;

    public ChoiceScreen() {
        super();
    }

    @Override
    public void init() {
        //default:
        intervalLength = 60000;
        paneHeight = (height / 2) + 50;
        paneWidth = (width / 2) + 10;
        createButtons();
    }

    private void createButtons() {
        int barHeight = (height / 2) - 55;
        int barHorz = (width/2)-75;
        this.addToGuiList(new GuiButton(barHorz - 125, barHeight, 50, 50, "30", onPressFunct -> this.intervalLength = 30000));
        this.addToGuiList(new GuiButton(barHorz - 25, barHeight, 50, 50, "45", onPressFunct -> this.intervalLength = 45000));
        this.addToGuiList(new GuiButton(barHorz - 75, barHeight, 50, 50, "60", onPressFunct -> this.intervalLength = 60000));
        this.addToGuiList(new GuiButton(barHorz + 25, barHeight, 50, 50, "90", onPressFunct -> this.intervalLength = 90000));
        this.addToGuiList(new GuiButton(barHorz + 75, barHeight, 50, 50, "120", onPressFunct -> this.intervalLength = 120000));
        this.addToGuiList(new GuiButton(barHorz + 125, barHeight, 50, 50, "180", onPressFunct -> this.intervalLength = 180000));
        this.addToGuiList(new GuiButton(barHorz + 175, barHeight, 50, 50, "300", onPressFunct -> this.intervalLength = 300000));
        this.addToGuiList(new GuiButton(barHorz + 225, barHeight, 50, 50, "600", onPressFunct -> this.intervalLength = 600000));
        this.addToGuiList(new GuiButton((width / 2) - 90 / 2, (height / 2) + 25, 90, 50, "Start", onPressFunct -> this.app.setScreen(new SlideshowScreen(intervalLength)))).setColorTxt(new Color(17, 108, 0));


    }

    @Override
    public void render(Graphics2D g2) {
        renderBackground(g2);
        renderPane(g2);
        for (GuiButton button : children) {
            button.render(g2);
            if (button.isHovered()) {
                g2.setColor(new Color(112, 91, 74, 81));
                button.drawHover(g2);
            }
        }
    }


    private void renderPane(Graphics2D g2) {
        g2.setColor(Color.lightGray);
        //rounded square
        g2.fillRoundRect((width / 2) - paneWidth / 2, (height / 2) - paneHeight / 2, paneWidth, paneHeight, 50, 50);
    }

    private void renderBackground(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fillRect(0, 0, width, height);
    }

    ///////

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (GuiButton button : children) {
            button.mouseClicked(e);
            button.onPress();
            resetButtons();
        }
    }

    private void resetButtons() {
        for (GuiButton button : children) {
            if (button.isHovered()) {
                button.setSelected(true);
            }
            if (button.isSelected() && !button.isHovered()) {
                button.setSelected(false);
            }

        }
    }
}
