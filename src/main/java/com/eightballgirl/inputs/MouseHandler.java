package com.eightballgirl.inputs;

import com.eightballgirl.main.Application;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private final Application app;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private boolean mouseGrabbed;

    public MouseHandler(final Application app) {

        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.getScreen().mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        app.getScreen().mouseMoved(e);
    }

    public void releaseTheMouse() {
        if (!this.mouseGrabbed){
            return;
        }
        this.mouseGrabbed = false;
    }
}
