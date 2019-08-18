package timerdemo;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorDemo {


    private ScheduledThreadPoolExecutor scheduled;

    public static void main(String[] args) {

        ScheduledThreadPoolExecutorDemo scheduledThreadPoolExecutorDemo = new ScheduledThreadPoolExecutorDemo();
        scheduledThreadPoolExecutorDemo.threadFactory();
    }

    public void threadFactory(){
        ThreadFactory nameThread = new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build();
        scheduled = new ScheduledThreadPoolExecutor(3, nameThread);
        scheduledDemo();
    }

    public void scheduledDemo(){
        /*scheduled.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("hello world!!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello!!!!!!!!!!!!!!!!!!!");
            }
        });*/
        scheduled.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("wo kao,ni xiang gan ma?");
            }
        },3,TimeUnit.SECONDS);
    }
}
