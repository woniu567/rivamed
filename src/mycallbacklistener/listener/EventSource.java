package mycallbacklistener.listener;

public class EventSource {

    private EventListener eventListener;
    public void run(){
        Event event = new Event();
        eventListener.doRun(event);
        System.out.println("跑步...");
    }

    public void eat(){
        Event event = new Event();
        eventListener.doEat(event);
        System.out.println("吃饭...");
    }

    public void registerListener(EventListener eventListener){
        this.eventListener = eventListener;
    }
}
