package threadpool.threadLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/*
引入显式锁的超时机制特性来避免死锁
超时机制是监控死锁和从死锁中恢复的技术，是使用每个显式锁Lock类中定时tryLock特性，来替代使用内部锁机制。在内部锁的机制中，
只要没有获得锁，就永远保持等待，而显示的锁使你能够定义超时的时间，在规定时间之后tryLock还没有获得锁就会返回失败。
通过使用超时，尽管这段时间比你预期能够获得锁的时间长很多，你仍然可以在意外发生后重新获得控制权。当尝试获得定时锁失败时，
你并不需要知道原因。也许是因为有死锁发生，也许是线程在持有锁的时候错误地进入无限循环；也有可能是执行一些活动所花费的时间比你
预期慢了许多。不过至少你有机会了解到你的尝试已经失败，记录下这次尝试中有用的信息，并重新开始计算，这远比关闭整个线程要优雅得多。

即使定时锁并没有应用于整个系统，使用它来获得多重锁还是能够有效应对死锁。如果获取锁的请求超时，你可以释放这个锁，并后退，
等待一会后再尝试，这很可能消除了死锁发生的条件，并且循序程序恢复。
(这项技术只有在同时获得两个锁的时候才有效；如果多个锁是在嵌套的方法中被请求的，你无法仅仅释放外层的锁，尽管你知道自己已经持有该锁)
显式锁Lock，Lock是一个接口，定义了一些抽象的锁操作。与内部锁机制不同，Lock提供了无条件，可轮询，定时的，可中断的锁获取操作，
所有加锁和解锁的方法都是显式的。Lock的实现必须提供举报与内部锁相同的内存可见性的语义。但是加锁的语义，调度算法，顺序保证，性能特性这些可以不同

Lock的源码如下：
 */
public interface Lock {

    //加锁
    void lock();

    //可中断的锁，打算线程的等待状态，即A线程已经获取该锁，B线程又来获取，但是A线程会通知B，来打算B线程的等待
    void lockInterruptibly() throws InterruptedException;

    //尝试去获取锁，失败返回False
    boolean tryLock();

    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    //释放锁
    void unlock();

    Condition newCondition();
}
