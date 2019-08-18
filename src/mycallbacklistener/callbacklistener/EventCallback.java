package mycallbacklistener.callbacklistener;

public class EventCallback implements Callback{

    @Override
    public boolean onRun() {
        System.out.println("跑步之前热身了吗??");
        return true;
    }

    @Override
    public boolean onEat() {
        System.out.println("吃饭之前洗手了吗??");
        return true;
    }

    public void askManager(Manager manager){
        manager.answer(this);
    }
}
