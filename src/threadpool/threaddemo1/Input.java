package threadpool.threaddemo1;

/**
 * 线程共享数据问题
 * 这一步是等待唤醒机制的核心部分。输入线程第一次进来时fig为false，继续往下执行。
 * set过后，将fig改为true，并且唤醒下一个线程（输出线程）。就算下一次输入线程又抢到了CPU的执行权，判断fig为true则等待。
 */
public class Input implements Runnable{

    private  User user;

    public Input() {    }

    public Input(User user) {//传入User对象
        this.user = user;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            synchronized (user){
                if (user.getFig()){ //如果已经输入数据 让线程等待
                    try {
                        user.wait();
                    }catch (InterruptedException e){

                    }
                }//为true就让线程等待
                if (i == 0){ //每次切换一下  添加不同的数据 方便观察
                    user.set("Rous","woman");
                }else {
                    user.set("杰克","男");
                }
                user.setFig(true); //改为true让输输入线程可以执行 输入线程等待
                user.notify(); //唤醒下一个线程
                i = (i + 1) % 2; //切换
            }
        }
    }
}
