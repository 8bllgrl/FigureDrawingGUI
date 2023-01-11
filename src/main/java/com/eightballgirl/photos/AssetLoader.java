package com.eightballgirl.photos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AssetLoader {
    //methods for loading images.
    //location of the folder that will be referenced.
    public static final String BACKBUTTON = "/img/gui/button/backward-step-solid.png";
    public static final String NEXTBUTTON = "/img/gui/button/forward-step-solid.png";

    public static BufferedImage GetImageAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = AssetLoader.class.getResourceAsStream(fileName);
        try {
            assert is != null;
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }


    public static BufferedImage AbsolutePathImageAtlas(String fileName){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
