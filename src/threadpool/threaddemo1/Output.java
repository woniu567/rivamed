package threadpool.threaddemo1;

/**
 * 假如输出线程第一次抢到CPU的执行权，判断fig为false（User对象默认值为false），等待。
 * 当输入线程执行一遍后，就会将fig改为true并且唤醒输出线程，此时输出线程才具备执行资格。
 * 输出线程执行一遍后，将fig置为false，并唤醒输入线程，以此往复。
 */
public class Output implements Runnable{

    private User user;

    public Output() {    }

    public Output(User user) {
        this.user = user;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (user) {
                if(!user.getFig()) {
                    try {
                        user.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(user.get());
                user.setFig(false);
                user.notify();
            }
        }
    }
}
