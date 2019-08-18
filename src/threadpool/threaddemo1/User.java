package threadpool.threaddemo1;

/**
 *
 * 当我们开启两条线程时，一条线程专门输入数据，另条取数据。并且要实现，输入一个数据过后，另一方取出一个数据。
 * 在多线程的情况下，当输入线程抢到CPU的执行权后，下一次还有可能是输入线程抢到CPU的执行权，就达不到我们想过要的效果。
 * 因此，我们需要输入线程执行一次过后，就让它等待，并叫醒输出线程。然后让输出线程执行，执行一次后等待，并且叫醒输入线程。
 * 就这样循环往复，就达到了我们想要的效果。
 */
public class User {

    private String name;
    private String sex;
    private boolean fig;//用来切换线程

    public User() {    }

    public void set(String name ,String sex){
        this.name = name;
        this.sex = sex;
    }

    public String get(){
        return this.name+"  :  "+this.sex;
    }

    public void setFig(boolean fig) {
        this.fig = fig;
    }

    public boolean getFig() {
        return fig;
    }

}
