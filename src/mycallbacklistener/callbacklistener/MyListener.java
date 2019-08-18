package mycallbacklistener.callbacklistener;

public class MyListener implements Listener{

    @Override
    public void doRun(Event event) {
        System.out.println("热身了-+-");
    }

    @Override
    public void doEat(Event event) {
        System.out.println("洗手了-+-");
    }
}
