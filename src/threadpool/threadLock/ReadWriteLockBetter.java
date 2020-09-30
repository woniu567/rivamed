package threadpool.threadLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

//可以看到线程间是不用排队来读操作的。这样效率明显很高
public class ReadWriteLockBetter {

    private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReadWriteLockTest test = new ReadWriteLockTest();
        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

    }

    public void get(Thread thread) {

        try {
            rw1.readLock().lock();
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在读操作");
            }
            System.out.println(thread.getName() + "读操作完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rw1.readLock().unlock();
        }
    }

}
