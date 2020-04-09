package threadpool.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

public class ThreadDemo {

    public static void main(String[] args) {
        ThreadFactory nameThread = new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build();
        //scheduled = new ScheduledThreadPoolExecutor(3,nameThread);
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(3);
        scheduled.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行完就停了....");
            }
        },3,TimeUnit.SECONDS);


        //表示延迟3秒执行。
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("5s后执行完就停了....");
            }
        }, 5, TimeUnit.SECONDS);
    }
}
