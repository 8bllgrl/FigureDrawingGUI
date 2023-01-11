package com.eightballgirl.constants;

import java.io.File;
import java.util.ArrayList;

public class AppConstants {

    public static String basePath = new File("").getAbsolutePath();
    public static int APPLICATION_WIDTH = 1500;
    public static int APPLICATION_HEIGHT = 900;
    public final static ArrayList<String> ALL_FILE_NAMES = new ArrayList<>();

    //finding image width based on height:
    //get the buffered image height
    //get the actual height
    //find the difference

    //    calculate the ratio of the width to height: original width / original height.
    //    multiply the width/height ratio by the new desired height to get the new width corresponding to the new height.
    public static int imgDiffWidth(int ogWidth, int ogHeight, int newHeight) {
        //https://stackoverflow.com/questions/10245220/resize-image-maintain-aspect-ratio
        return (newHeight * ogWidth) / ogHeight;
    }


    public static String returnsFilepathExtended() {

        //user of code may differ.
        String path = new File(basePath + "\\src\\main\\resources\\img\\gallery\\").getAbsolutePath();
        return path;
    }


    public static void recursiveMethod(File[] targetArray, int index, int level) {
// terminate condition
        if (index == targetArray.length) {
            return;
        }
        // for files
        if (targetArray[index].isFile()) {
            ALL_FILE_NAMES.add(targetArray[index].getAbsolutePath());
        }


        // for sub-directories
        else if (targetArray[index].isDirectory()) {
            // recursion for sub-directories
            recursiveMethod(targetArray[index].listFiles(), 0,
                    level + 1);
        }
        // recursion for main directory
        recursiveMethod(targetArray, ++index, level);
    }


    public static int difference(int larger, int smaller) {
        return larger - smaller;
    }


}
