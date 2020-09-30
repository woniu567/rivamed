package threadpool.threadLock;

/*
ReentrantLock实现了标准的互斥锁：一次最多只有一个线程能够持有相同ReentrantLock。但是互斥通常做为保护数据一致性的很强的加锁约束，
因此，过分的限制了并发性。互斥是保守的加锁策略，避免了“写/写”和“写/读"的重读，但是同样避开了"读/读"的重叠。在很多情况下，
数据结构是”频繁被读取“的——它们是可变的，有时候会被改变，但多数访问只进行读操作。此时，如果能够放宽，允许多个读者同时访问数据结构就
非常好了。只要每个线程保证能够读到最新的数据(线程的可见性)，并且在读者读取数据的时候没有其他线程修改数据，就不会发生问题。
这就是读-写锁允许的情况：一个资源能够被多个读者访问，或者被一个写者访问，两者不能同时进行。
ReadWriteLock，暴露了2个Lock对象，一个用来读，另一个用来写。读取ReadWriteLock锁守护的数据，你必须首先获得读取的锁，
当需要修改ReadWriteLock守护的数据，你必须首先获得写入锁。

ReadWriteLock源码接口如下：
 */
public interface ReadWriteLock {

    /**
     * Returns the lock used for reading.
     *
     * @return the lock used for reading
     */

    Lock readLock();

    /**
     * Returns the lock used for writing.
     *
     * @return the lock used for writing
     */
    Lock writeLock();
}
