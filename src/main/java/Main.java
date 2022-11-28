import SpyCode.ScreenshotRec.PrntScreen;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        PrntScreen prntScreen = new PrntScreen();

        for(;;){
            Thread.sleep(10000);
            prntScreen.photo();
        }
    }
}
