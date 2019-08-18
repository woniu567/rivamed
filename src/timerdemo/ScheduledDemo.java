package timerdemo;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledDemo {

    private static ScheduledThreadPoolExecutor scheduled;

    public static void main(String[] args) {

        if (scheduled == null) {
            scheduled = new ScheduledThreadPoolExecutor(3);
        }
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("ding shi ren wu!!!!!");
            }
        }, 1, 5,TimeUnit.SECONDS);
    }

}
