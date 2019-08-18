package mylistener.demo1;

public class MyEventListener implements EventListener{

    public MyEventListener() {
        super();
    }

    @Override
    public void doRun(EventSelf eventSelf) {
        System.out.println("跑步之前要。。。带安全帽吧！^_^");
    }

    @Override
    public void doEat(EventSelf eventSelf) {
        System.out.println("吃饭之前要洗手！");
    }
}
