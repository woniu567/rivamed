package threadpool.threadLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
读写锁实现的加锁策略允许多个同时存在的读者，但是只允许一个写者。与Lock一样，ReadWriteLock允许多种实现，造成性能，调度保证，获取优先，公平性，
以及加锁语义等方面的不尽相同。读写锁的设计是用来进行性能改进的，使得特定情况下能够有更好的并发性。时间实践中，当多处理器系统中，
频繁的访问主要为读取数据结构的时候哦，读写锁能够改进性能；在其他情况下运行的情况比独占的锁要稍微差一些，这归因于它更大的复杂性。
使用它能否带来改进，最好通过对系统进行剖析来判断：好在ReadWriteLock使用Lock作为读写部分的锁，所以如果剖析得的结果发现读写锁没有能提高性能，把读写锁置换为独占锁是比较容易。

下面我们用synchonized来进行读操作，对于读操作性能如何呢？
可以看到要线程Thread0读操作完了，Thread1才能进行读操作。明显这样性能很慢。
 */
public class ReadWriteLockTest {

    private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        final ReadWriteLockTest test = new ReadWriteLockTest();
        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
    }

    public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 1){
            System.out.println(thread.getName() + "正在读操作");
        }
        System.out.println(thread.getName() + "读操作完成");
    }
}
