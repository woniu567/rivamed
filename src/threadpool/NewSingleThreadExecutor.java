package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序（FIFO， LIFO， 优先级）执行
public class NewSingleThreadExecutor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println(index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        /*ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }*/

    }
}
