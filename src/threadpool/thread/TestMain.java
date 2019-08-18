package threadpool.thread;

public class TestMain {

    public static void main(String[] args) {

        DeadLock dl = new DeadLock();
        dl.a.start();
        dl.b.start();

        //dl.a.notify();
        //dl.b.notify();
    }
}
