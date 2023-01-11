package com.eightballgirl.main;

import javax.swing.*;
import java.awt.*;

public class ApplicationWindow {
    private JFrame frame;

    public ApplicationWindow(ApplicationRenderer appRender){

        frame = new JFrame();
//        frame.setUndecorated(true);

        frame.getRootPane().setOpaque(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(appRender);

        //size
        frame.setResizable(false);
        frame.pack();

        frame.setTitle("Slideshow App");
        frame.setBackground(Color.black);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
