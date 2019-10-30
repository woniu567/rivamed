package threadpool;

public class MainDemo {

    public static void main(String[] args) {
        ThreadRunnable threadRunnable = new ThreadRunnable();
        new Thread(threadRunnable.runnable).start();
    }
}
