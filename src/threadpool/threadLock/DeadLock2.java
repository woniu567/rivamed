package threadpool.threadLock;

/*
如果所有线程以通用的固定秩序获取锁，程序就不会出现锁顺序死锁问题了。
什么情况下会发生死锁呢？
1.锁的嵌套容易发生死锁。解决办法：获取锁时，查看是否有嵌套。尽量不要用锁的嵌套，如果必须要用到锁的嵌套，就要指定锁的顺序，
因为参数的顺序是超乎我们控制的，为了解决这个问题，我们必须指定锁的顺序，并且在整个应用程序中，获得锁都必须始终遵守这个既定的顺序。

上面的例子出现死锁的根本原因就是获取所的顺序是乱序的，超乎我们控制的。上面例子最理想的情况就是把业务逻辑抽离出来，
把获取锁的代码放在一个公共的方法里面，让这两个线程获取锁都是从我的公共的方法里面获取，当Thread1线程进入公共方法时，获取了A锁，
另外Thread2又进来了，但是A锁已经被Thread1线程获取了，Thread1接着又获取锁B，Thread2线程就不能再获取不到了锁A，更别说再去获取锁B了，这样就有一定的顺序了。
DeadLock1例子的改造如下

可以看到把业务逻辑抽离出来，把获取锁的代码放在一个公共的方法里面，获得锁都必须始终遵守这个既定的顺序。
 */
public class DeadLock2 {

    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        new DeadLock2().deadLock();
    }

    private void deadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                getLock();
            }
        },"Thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                getLock();
            }
        },"Thread2");
        thread1.start();
        thread2.start();
    }

    public void getLock(){
        synchronized (lockA){
            try {
                System.out.println(Thread.currentThread().getName() + "获取A锁 ing！");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "需要B锁!!!");
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "B锁获取成功!");
            }
        }
    }
}
