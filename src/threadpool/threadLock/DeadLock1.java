package threadpool.threadLock;

/*
一.死锁

经典的“哲学家进餐”问题很好的阐释了死锁。5个哲学家一起出门去吃中餐，他们围坐在一个圆桌边。他们只有五只筷子(不是5双)，每两个人中间放有一只。
哲学家边吃边思考，交替进行。每个人都需要获得两只筷子才能吃东西，但是吃后要把筷子放回原处继续思考。有一些管理筷子的算法，使每一个人都能够或多或少，及时
吃到东西(一个饥饿的哲学家试图获得两只临近的筷子，但是如果其中的一只正在被别人占用，那么他英爱放弃其中一只可用的筷子，等待几分钟再尝试)。但是这样做可能导致
一些哲学家或者所有哲学家都饿死 (每个人都迅速捉住自己左边的筷子，然后等待自己右边的筷子变成可用，同时并不放下左边的筷子)。这最后一种情况，当每个人都拥有他人需要的
资源，并且等待其他人正在占有的资源，如果大家一致占有资源，直到获得自己需要却没被占有的其他资源，那么就会产生死锁。
当一个线程永远占有一个锁，而其他线程尝试去获得这个锁，那么他们将永远被阻塞。当线程Thread1占有锁A时，想要获得锁B，但是同时线程Thread2持有B锁，并尝试获得A锁，两个线程将永远等待下去。
这种情况是死锁最简单的形式.
 */
/*
结果很明显了，这两个线程陷入了死锁状态了，发生死锁的原因是，两个线程试图通过不同的顺序获得多个相同的锁。如果请求锁的顺序相同，
就不会出现循环的锁依赖现象(你等我放锁，我等你放锁)，也就不会产生死锁了。如果你能够保证同时请求锁A和锁B的每一个线程，都是按照从锁A到锁B的顺序，那么就不会发生死锁了。
 */
public class DeadLock1 {

    private static Object lockA = new Object();

    private static Object lockB = new Object();

    public static void main(String[] args){
        new DeadLock1().deadLock();
    }

    private void deadLock(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    try {
                        System.out.println(Thread.currentThread().getName() + "获取A锁 ing!");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + "睡眠500ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "需要B锁!!!");
                    synchronized (lockB){
                        System.out.println(Thread.currentThread().getName() + "B锁获取成功!");
                    }
                }
            }
        },"Thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB){
                    try {
                        System.out.println(Thread.currentThread().getName() + "获取B锁 ing!!!");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + "睡眠500ms");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "需要A锁!!!");
                    synchronized (lockA){
                        System.out.println(Thread.currentThread().getName() + "A锁获取成功!");
                    }
                }
            }
        },"Thread2");

        thread1.start();
        thread2.start();
    }
}
