package mycallbacklistener.callbacklistener;

public class EventSource {

    private Listener listener;
    public void run(){
        Event event = new Event();
        listener.doRun(event);
        System.out.println("那就跑步吧...");
    }

    public void eat(){
        Event event = new Event();
        listener.doEat(event);
        System.out.println("那就吃饭吧...");
    }

    public void registerListener(Listener listener){
        this.listener = listener;
    }
}
