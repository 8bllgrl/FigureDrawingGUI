package com.eightballgirl.main;

import com.eightballgirl.constants.ImageContants;

public class Main {

    //later i can change and pass in the intervals inside of here.
    public static void main(String[] args) {
        int defaultIntervallength = 120000;
        boolean quickStart = true;
        new Application(defaultIntervallength,quickStart);
    }
}
