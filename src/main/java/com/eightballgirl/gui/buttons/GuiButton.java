package com.eightballgirl.gui.buttons;

import com.eightballgirl.constants.AppConstants;
import com.eightballgirl.photos.AssetLoader;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GuiButton {

    int x;
    int y;
    int width;
    int height;
    Rectangle bounds;
    protected boolean isHovering;
    protected int boundsBuffer;
    protected String name;
    public Color colorBg;
    public Color colorTxt;
    private boolean selected;

    protected BufferedImage appearance;

    protected OnPress onPress;

    //onpress button
    public GuiButton(int x, int y, int width, int height, String name, OnPress onPress){
        this(x,y,width,height);
        this.onPress = onPress;
        this.name = name;
        this.colorBg = Color.black;
        this.colorTxt = new Color(168, 113, 68);
        this.selected=false;
    }
    public GuiButton(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        setBounds(x,y,width,height);
    }
    public GuiButton(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBounds(x,y,width,height);
    }


    public void setBounds(int x, int y, int width, int height) {
        this.bounds = new Rectangle(x, y, width, height);
    }


    public void setAppearance(String string) {
        appearance = AssetLoader.GetImageAtlas(string);
    }

    public void render(Graphics2D g2) {
        if (appearance !=null){
            g2.drawImage(appearance, x, y, width, height, null);
            return;
        }
        if (selected){
            g2.setColor(Color.darkGray);
            g2.fillRoundRect(x,y,width,height,15,15);
        }
        g2.setColor(colorBg);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x,y,width,height,15,15);
        g2.setColor(colorTxt);
        int fontsize = 28;
        g2.setFont(new Font("Comic Sans", Font.PLAIN, fontsize));
        g2.drawString(name,x+3,y+(height/2)+(fontsize/2)-5);
    }

    public void setWidth() {
        this.width = AppConstants.imgDiffWidth(appearance.getWidth(), appearance.getHeight(), height);
    }


    public void setColorTxt(Color colorTxt) {
        this.colorTxt = colorTxt;
    }

    public boolean isHovered(MouseEvent e) {
        return this.bounds.contains(e.getX(), e.getY());
    }
    public boolean isHovered() {
        return isHovering;
    }

    public void mouseMoved(MouseEvent e) {
        isHovering = isHovered(e);
    }

    public void mouseClicked(MouseEvent e) {
        if (isHovering){
            setSelected(!isSelected());
        }

    }

    public void drawHover(Graphics2D g2) {
        g2.fillRect(x,y,width,height);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void onPress() {
        if (isHovered()){
            this.onPress.onPress(this);
        }
    }



    //when hovered, fill a semi-opaque black rect over it.

    public interface OnPress {
        void onPress(final GuiButton button);
    }
}
