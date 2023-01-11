package com.eightballgirl.gui;

import java.awt.*;

public class TimerVisualizer implements GuiRenderable{

    public static String displayString = "5000";

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.gray);
        g2.setFont(new Font("Comic Sans", Font.PLAIN, 35));
        g2.drawString(displayString, 1400,880);
    }

    public String getDisplayString() {
        return displayString;
    }

    public void setDisplayString(String string){
        displayString = string;
    }
}
