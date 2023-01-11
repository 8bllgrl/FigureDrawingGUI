package com.eightballgirl.gui;

import com.eightballgirl.constants.AppConstants;
import com.eightballgirl.gui.buttons.ButtonPause;
import com.eightballgirl.gui.buttons.GuiButton;
import com.eightballgirl.gui.buttons.ButtonBack;
import com.eightballgirl.gui.buttons.ButtonNext;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SlideshowDeck implements GuiRenderable {


    public int width;
    public int height;
    public int x;
    private ButtonBack goback;
    private ButtonNext gonext;
    private ButtonPause pause;
    private ArrayList<GuiButton> buttons;
    private Color hover = new Color(0,0,0, 136);

    public SlideshowDeck() {
        this.height = 75;
        this.width = AppConstants.APPLICATION_WIDTH;
        initButtons();
    }

    public void initButtons() {
        gonext = new ButtonNext((AppConstants.APPLICATION_WIDTH/2)+65,(AppConstants.APPLICATION_HEIGHT - height)+5,50);
        goback = new ButtonBack((AppConstants.APPLICATION_WIDTH/2)-50,(AppConstants.APPLICATION_HEIGHT - height)+5,50);
        pause = new ButtonPause((AppConstants.APPLICATION_WIDTH/2),(AppConstants.APPLICATION_HEIGHT - height)+5,50);
        buttons = new ArrayList<>();
        buttons.add(goback);
        buttons.add(gonext);
        buttons.add(pause);
    }

    @Override
    public void render(Graphics2D g2) {
        //draw bottom black row
        //draw buttons for each
        g2.setColor(Color.black);
        g2.fillRect((AppConstants.APPLICATION_WIDTH - width) / 2, AppConstants.APPLICATION_HEIGHT - height, width, height);
        for (GuiButton button : buttons){
            button.render(g2);
            if (button.isHovered()){
                g2.setColor(hover);
                button.drawHover(g2);
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        for (GuiButton button : buttons){
            button.mouseMoved(e);
        }
    }
    public void mouseClicked(MouseEvent e) {
        for (GuiButton button : buttons){
            button.mouseClicked(e);
        }

    }


}
