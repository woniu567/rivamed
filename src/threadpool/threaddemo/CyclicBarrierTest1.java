package threadpool.threaddemo;

/**
 *  例子2：还是上面程序，顺序不同，把线程3放到最下面。最后线程1,2都因为没有再次获得线程导致线程阻塞
 *
 *  运行过程：
 *  线程1先运行获得sum对象锁（通过synchronized），但是随后执行了sum.wait()方法，主动释放掉了sum对象锁，
 *  然后线程2获得了sum对象锁（通过synchronized）,也通过sum.wait()失去sum的对象锁，最后线程3获得了sum对象锁（通过synchronized），
 *  主动通过sum.notify()通知了线程1或者2，假设是1，线程1重新通过notify()/notifyAll()的方式获得了锁，然后执行完毕，随后线程释放锁，
 *  然后这个时候线程2成功获得锁，执行完毕。
 */

public class CyclicBarrierTest1 {

    public static void main(String[] args) throws Exception {
        final Sum sum=new Sum();

        /*new Thread(new Runnable() {
            @Override
            public void  run() {
                try {
                    synchronized (sum) {
                        System.out.println("thread1 get lock");
                        sum.wait();//主动释放sum对象锁，等待唤醒
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
                        sum.wait();  //主动释放sum对象锁，等待唤醒
                        System.out.println(sum.total);
                        System.out.println("thread2 release lock");
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
                        System.out.println("thread3 get lock");
                        sum.sum();
                        sum.notifyAll();//唤醒其他等待线程（线程1,2）
                        Thread.sleep(2000);
                        System.out.println("thread3 really release lock");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

    }
}
