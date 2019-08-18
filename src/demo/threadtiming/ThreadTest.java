package demo.threadtiming;

public class ThreadTest {

    public static void main(String[] args) {
        // run in a second
        //final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- ends here
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // ------- code for task to run
                    System.out.println("Hello !!");
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
