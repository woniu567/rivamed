package threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  使用线程池的好处有很多，比如节省系统资源的开销，节省创建和销毁线程的时间等，当我们需要处理的任务较多时，就可以使用线程池，可能还有很多用户不知道Java线程池如何使用？下面小编给大家分享Java四种线程池的使用方法。
 *
 *  线程池介绍：
 * 　　线程池是一种多线程处理形式，处理过程中将任务添加到队列，然后在创建线程后自动启动这些任务。线程池线程都是后台线程。每个线程都使用默认的堆栈大小，以默认的优先级运行，并处于多线程单元中。
 *     如果某个线程在托管代码中空闲（如正在等待某个事件），则线程池将插入另一个辅助线程来使所有处理器保持繁忙。如果所有线程池线程都始终保持繁忙，但队列中包含挂起的工作，则线程池将在一段时间后
 *     创建另一个辅助线程但线程的数目永远不会超过最大值。超过最大值的线程可以排队，但他们要等到其他线程完成后才启动。
 */
public class NewCachedThreadPool {

    //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。示例代码如下：
    /*Java四种线程池的使用：
            　　Java通过Executors 提供四种线程池，分别为：
            　　newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
            　　newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
            　　newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
            　　newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序（FIFO， LIFO， 优先级）执行。*/
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }
}
