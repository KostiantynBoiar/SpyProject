package Threads;

import SpyCode.ScreenshotRec.PrntScreen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrntScreenThread implements Runnable{
    public List<String> listOfScreenshots = new ArrayList<>();

    @Override
    public void run() {
        PrntScreen prntScreen = new PrntScreen();

        try {
            String name = prntScreen.photo();
            listOfScreenshots.add(name);

        } catch (IOException | AWTException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }
}
