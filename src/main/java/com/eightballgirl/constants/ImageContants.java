package com.eightballgirl.constants;

import com.eightballgirl.photos.AssetLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ImageContants {

    public static String[] absolutePathsOfImages;
    public static ArrayList<String> usedImages;
    public static BufferedImage currentImage;
    public static String currentImageFilePath;
    public static int imageIndex;

    public static void init() {
        absolutePathsOfImages = getFileList();
        usedImages = new ArrayList<>();
        ImageContants.setImage(getRandomUnusedFile());
    }

    public static String[] getFileList() {
        String[] returnStringArray = null;
        String galleryLocation = returnsFilepathProkoGallery();
        File folderDirectory = new File(galleryLocation);
        if (folderDirectory.exists() && folderDirectory.isDirectory()) {
            // array for files and sub-directories
            // of directory pointed by maindir
            File[] arr = folderDirectory.listFiles();

            // Calling recursive method
            AppConstants.recursiveMethod(arr, 0, 0);

            returnStringArray = new String[AppConstants.ALL_FILE_NAMES.size()];
            for (int i = 0; i < AppConstants.ALL_FILE_NAMES.size(); i++) {
                returnStringArray[i] = AppConstants.ALL_FILE_NAMES.get(i);
            }
        }

        return returnStringArray;
    }


    public static String returnsFilepathProkoGallery() {
        String path = AppConstants.returnsFilepathExtended();

        return path;
    }

    public static void setImage(String filename) {
        currentImage = AssetLoader.AbsolutePathImageAtlas(filename);
        imageIndex = usedImages.size();
        //update screen
    }

    public static void recursiveMethod(File[] targetArray, int index, int level) {
// terminate condition
        if (index == targetArray.length) {
            return;
        }
        // for files
        if (targetArray[index].isFile()) {
            AppConstants.ALL_FILE_NAMES.add(targetArray[index].getAbsolutePath());
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

    public static String getRandomUnusedFile() {
        int random = new Random().nextInt(absolutePathsOfImages.length);

        while (ImageContants.usedImages.contains(absolutePathsOfImages[random])) {
            random = new Random().nextInt(absolutePathsOfImages.length);
        }
        ImageContants.usedImages.add(absolutePathsOfImages[random]);
        imageIndex = usedImages.size()-1;
        currentImageFilePath = usedImages.get(imageIndex);
        return usedImages.get(imageIndex);
    }

    public static String getPreviousImage(){
        return usedImages.get((imageIndex-1)-1);
    }
}
