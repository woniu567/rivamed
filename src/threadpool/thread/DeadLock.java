package threadpool.thread;

public class DeadLock {

    public static String str1 = "str1";
    public static String str2 = "str2";
    //public static String str2 = "str1";
    //在声明一个对象作为锁的时候要注意字符串类型锁对象，因为字符串有一个常量池，
    //如果不同的线程持有的锁是具有相同字符的字符串锁时，两个锁实际上同一个锁。

    Thread a = new Thread(() -> {
        try{
            while(true){
                synchronized(DeadLock.str1){
                    System.out.println(Thread.currentThread().getName()+"锁住 str1");
                    /*if (Thread.currentThread().getName().equals("Thread-1")){
                        str2.wait(500);
                    }else if (Thread.currentThread().getName().equals("Thread-0")){
                        str1.wait(500);
                    }*/
                    synchronized(DeadLock.str2){
                        System.out.println(Thread.currentThread().getName()+"锁住 str2");
                        /*if (Thread.currentThread().getName().equals("Thread-1")){
                            str2.wait(500);
                        }else if (Thread.currentThread().getName().equals("Thread-0")){
                            str1.wait(500);
                        }*/
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    });

    Thread b = new Thread(() -> {
        try{
            while(true){
                synchronized(DeadLock.str2){
                    System.out.println(Thread.currentThread().getName()+"锁住 str2");
                    /*if (Thread.currentThread().getName().equals("Thread-1")){
                        str2.wait(500);
                    }else if (Thread.currentThread().getName().equals("Thread-0")){
                        str1.wait(500);
                    }*/
                    synchronized(DeadLock.str1){
                        System.out.println(Thread.currentThread().getName()+"锁住 str1");
                        /*if (Thread.currentThread().getName().equals("Thread-1")){
                            str2.wait(500);
                        }else if (Thread.currentThread().getName().equals("Thread-0")){
                            str1.wait(500);
                        }*/
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    });

    //a.start();
    //b.start();

}
