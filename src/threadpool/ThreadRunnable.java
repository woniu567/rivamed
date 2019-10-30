package threadpool;

public class ThreadRunnable {

    public ThreadRunnable(){}

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            while (true){
                System.out.println("hello world!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
