package threadpool.threaddemo;


/**
 * java锁之wait,notify(wait会释放锁，notify仅仅只是通知，不释放锁)
 * wait是指在一个已经进入了同步锁的线程内，让自己暂时让出同步锁，以便其他正在等待此锁的线程可以得到同步锁并运行，
 * 只有其他线程调用了notify方法（notify并不释放锁，只是告诉调用过wait方法的线程可以去参与获得锁的竞争了，
 * 但不是马上得到锁，因为锁还在别人手里，别人还没释放），调用wait方法的一个或多个线程就会解除wait状态，重新参与竞争对象锁，程序如果可以再次得到锁，就可以继续向下运行。
 *
 *   1）wait()、notify()和notifyAll()方法是本地方法，并且为final方法，无法被重写。
 *
 * 　2）当前线程必须拥有此对象的monitor（即锁），才能调用某个对象的wait()方法能让当前线程阻塞，
 *     （这种阻塞是通过提前释放synchronized锁，重新去请求锁导致的阻塞，这种请求必须有其他线程通过notify()或者notifyAll（）唤醒重新竞争获得锁）
 *
 * 　3）调用某个对象的notify()方法能够唤醒一个正在等待这个对象的monitor的线程，如果有多个线程都在等待这个对象的monitor，则只能唤醒其中一个线程；
 *  （notify()或者notifyAll()方法并不是真正释放锁，必须等到synchronized方法或者语法块执行完才真正释放锁）
 *
 * 　4）调用notifyAll()方法能够唤醒所有正在等待这个对象的monitor的线程，唤醒的线程获得锁的概率是随机的，取决于cpu调度
 *
 *   例子1（错误使用导致线程阻塞）：三个线程，线程3先拥有sum对象的锁，然后通过sum.notify()方法通知等待sum锁的线程去获得锁，但是这个时候线程1,2并没有处于wait()导致的阻塞状态，
 *   而是在synchronized方法块处阻塞了，所以，这次notify()根本没有通知到线程1,2。然后线程3正常结束，释放掉sum锁，这个时候，线程1就立刻获得了sum对象的锁（通过synchronized获得），
 *   然后调用sum.wait()方法释放掉sum的锁，线程2随后获得了sum对象的线程锁（通过synchronized获得），这个时候线程1,2都处于阻塞状态，但是悲催的是，
 *   这之后再也没有线程主动调用sum.notify()或者notifyAll()方法显示唤醒这两个线程，所以程序阻塞
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws Exception {
        final Sum sum=new Sum();

        new Thread(new Runnable() {
            @Override
            public void  run() {
                try {
                    synchronized (sum) {
                        System.out.println("thread3 get lock");
                        sum.sum();
                        sum.notifyAll(); //此时唤醒没有作用，没有线程等待
                        Thread.sleep(2000);
                        System.out.println("thread3 really release lock");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void  run() {
                try {
                    synchronized (sum) {
                        System.out.println("thread1 get lock");
                        sum.wait();//主动释放掉sum对象锁
                        System.out.println(sum.total);
                        System.out.println("thread1 release lock");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void  run() {
                try {
                    synchronized (sum) {
                        System.out.println("thread2 get lock");
                        sum.wait();  //释放sum的对象锁，等待其他对象唤醒（其他对象释放sum锁）
                        System.out.println(sum.total);
                        System.out.println("thread2 release lock");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
