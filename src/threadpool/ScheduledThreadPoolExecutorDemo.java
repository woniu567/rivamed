package threadpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {

    public static void main(String[] args) {

        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(3);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("disfaoiewior!!");
            }
        },3,10,TimeUnit.SECONDS);
    }



}
