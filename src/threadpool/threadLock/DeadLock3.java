package threadpool.threadLock;


/*
ReentranLock实现了Lock接口，提供了与synchronized相同的互斥和内存可见性的保证。获得ReentrantLock的锁与进入synchronized块有着相同内存含义，
释放ReentrantLock锁与退出synchronized块有着相同内存含义。ReentrantLock提供了与synchronized一样可重入加锁的语义。
ReentrantLock支持Lock接口定义的所有获取锁的方式。与synchronized相比，ReentranLock为处理不可用的锁提供了更多灵活性。但是对于现在的JDK的更新，
synchronized的性能被优化的越来越好，内部锁(synchronized)已经获得相当可观的性能，性能不仅仅是个不断变化的目标，而且变化的非常快。
如内部锁图所示
看到图，随着JDK的更新迭代，内部锁的性能越来越快，这不是ReentrantLock的衰退，而是内部锁(synchronized)越来越快，特别在JDK目前跟新到现在1.9.
 */

import java.util.concurrent.locks.ReentrantLock;

//下面用显式锁Lock再来改造前面的例子
public class DeadLock3 {

    Lock lock = (Lock) new ReentrantLock();

    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        new DeadLock3().deadLock();
    }

    private void deadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取A锁 ing！");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + "睡眠500ms");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

                System.out.println(Thread.currentThread().getName() + "需要B锁！！！");

                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "B锁获取成功！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        },"thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取B锁 ing！");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + "睡眠500ms");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

                System.out.println(Thread.currentThread().getName() + "需要A锁！！！");

                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "A锁获取成功！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        },"thread2");
        thread1.start();
        thread2.start();
    }
}
/*
可以看到显示锁Lock是可以避免死锁的。
注意：Lock接口规范形式。这种模式在某种程度上比使用内部锁更加复杂：锁必须在finally块中释放。另一方面，如果锁守护的代码在try块之外抛出了异常，它将永远都不会被释放了；
如果对象能够被置于不一致状态，可能需要额外的try-catch，或try-finally块。(当你在使用任何形式的锁时，你总是应该关注异常带来的影响，包括内部锁)。
忘记时候finally释放Lock是一个定时炸弹。当不幸发生的时候，你将很难追踪到错误的发生点，因为根本没有记录锁本应该被释放的位置和时间。
这就是ReentrantLock不能完全替代synchronized的原因：它更加危险，因为当程序的控制权离开守护的块，不会自动清除锁。尽管记得在finally块中释放锁并不苦难，但忘记的可能仍然存在。
 */